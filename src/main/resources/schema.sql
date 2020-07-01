CREATE TABLE characters (character_id VARCHAR(36) PRIMARY KEY, name VARCHAR(100), gender VARCHAR(1));
CREATE TABLE titles (title_id VARCHAR(36) PRIMARY KEY, character_id VARCHAR(36), title VARCHAR(255));
CREATE TABLE aliases (alias_id VARCHAR(36) PRIMARY KEY, character_id VARCHAR(36), alias VARCHAR(255));
CREATE TABLE houses (house_id VARCHAR(36) PRIMARY KEY, name VARCHAR(100), words VARCHAR(255));
CREATE TABLE characters_houses (house_id VARCHAR(36), character_id VARCHAR(36));
