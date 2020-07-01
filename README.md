# Spring Boot and GraphQL Example

A simple example of Spring Boot and GraphQL integration.

[Postman](https://www.postman.com/) Collection [here](docs).

Original data [here](https://github.com/joakimskoog/AnApiOfIceAndFire).

## Links

- [GraphQL](https://graphql.org/)
- [Introduction to GraphQL](https://graphql.org/learn/)
- [How to GraphQL](https://www.howtographql.com/)
- [GraphQL Java](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)
- [GraphQL Java Lib](https://www.graphql-java-kickstart.com/spring-boot/)

## Lectures

- [Netflix: Our learnings from adopting GraphQL](https://netflixtechblog.com/our-learnings-from-adopting-graphql-f099de39ae5f)

## Commands

`make test` run unit test

`make it` run integration test

`make run` run the app

## Tools

`make h2-console` open h2 console (db name `got`)

`make graphiql` open graphiql console

`make voyager` open voyager console

## GraphQL Queries

Endpoint `POST` `http://localhost:8080/graphql`.

```graphql
query findAllCharacters {
    characters {
        name
        titles {
            title
        }
        aliases {
            alias
        }
        houses {
            name
            words
        }
    }
}
```

## REST Query

Endpoint `GET` `http://localhost:8080/characters`.