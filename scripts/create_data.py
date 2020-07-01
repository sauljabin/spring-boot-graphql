#!python
# Data https://github.com/joakimskoog/AnApiOfIceAndFire

import json
import os
import uuid

DATA_SQL = '../src/main/resources/data.sql'
SCHEMA_SQL = '../src/main/resources/schema.sql'


def sql_insert_format(table, record):
    columns = ', '.join([column for column, value in record.items()])
    values = ', '.join(["'" + value.replace("'", "''").replace('\n', ' ') + "'" for column, value in record.items()])
    return 'INSERT INTO {} ({}) values ({});\n'.format(table, columns, values)


def sql_create_table_format(table, schema):
    columns = ', '.join(['{} {}'.format(column, column_type) for column, column_type in schema.items()])
    return 'CREATE TABLE {} ({});\n'.format(table, columns)


def load_data(file):
    with open(file, 'r') as file:
        data = json.load(file)
    return data


def process_data():
    original_houses = load_data('houses.json')
    original_characters = load_data('characters.json')

    characters = []
    titles = []
    aliases = []
    houses = []
    characters_houses = []

    for char in original_characters:
        if len(char['TvSeries']) <= 0 or not char['Name'] or char['Name'] == 'Unknown':
            continue

        character_id = str(uuid.uuid1())

        characters.append(
            {
                'character_id': character_id,
                'name': char['Name'],
                'gender': 'F' if char['IsFemale'] else 'M'
            }
        )

        titles.extend([
            {
                'title_id': str(uuid.uuid1()),
                'title': title,
                'character_id': character_id
            }
            for title in char['Titles']
        ])

        aliases.extend([
            {
                'alias_id': str(uuid.uuid1()),
                'alias': alias,
                'character_id': character_id
            }
            for alias in char['Aliases']
        ])

        for original_house_id in char['Allegiances']:
            house_id = str(uuid.uuid1())

            house_found = [
                {
                    'house_id': house_id,
                    'name': house['Name'],
                    'words': house['Words']
                }
                for house in original_houses if house["Id"] == original_house_id and house['Name']
            ]

            if not house_found:
                continue

            house_found = house_found[0]

            house_duplicated = [house for house in houses if house['name'] == house_found['name']]
            if not house_duplicated:
                houses.append(house_found)
            else:
                house_found = house_duplicated[0]

            characters_houses.append({'character_id': character_id, 'house_id': house_found['house_id']})

    return characters, titles, aliases, houses, characters_houses


def create_schema(table, schema):
    with open(SCHEMA_SQL, 'a') as file:
        file.write(sql_create_table_format(table, schema))


def create_insert(table, data):
    with open(DATA_SQL, 'a') as file:
        for record in data:
            file.write(sql_insert_format(table, record))


# DELETE SQL SCHEMA
if os.path.exists(SCHEMA_SQL):
    os.remove(SCHEMA_SQL)

# DELETE SQL DATA
if os.path.exists(DATA_SQL):
    os.remove(DATA_SQL)

# CREATE SQL SCHEMA
create_schema('characters',
              {
                  'character_id': 'VARCHAR(36) PRIMARY KEY',
                  'name': 'VARCHAR(100)',
                  'gender': 'VARCHAR(1)'}
              )
create_schema('titles',
              {
                  'title_id': 'VARCHAR(36) PRIMARY KEY',
                  'character_id': 'VARCHAR(36)',
                  'title': 'VARCHAR(255)'}
              )
create_schema('aliases',
              {
                  'alias_id': 'VARCHAR(36) PRIMARY KEY',
                  'character_id': 'VARCHAR(36)',
                  'alias': 'VARCHAR(255)'}
              )

# CREATE SQL DATA
characters_, titles_, aliases_, houses_, characters_houses_ = process_data()
create_insert('characters', characters_)
create_insert('titles', titles_)
create_insert('aliases', aliases_)
# create_insert('houses', houses_)
# create_insert('characters_houses', characters_houses_)
