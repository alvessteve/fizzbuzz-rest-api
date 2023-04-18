# Fizzbuzz REST API

## Enoncé

Write a simple fizz-buzz REST server.

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by "fizz",
all multiples of 5 by "buzz", and all multiples of 15 by "fizzbuzz". The output would look like this: "
1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...".

Your goal is to implement a web server that will expose a REST API endpoint that:

Accepts five parameters : three integers int1, int2 and limit, and two strings str1 and str2.

Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples
of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.

The server needs to be:

Ready for production

Easy to maintain by other developers

- Add a statistics endpoint allowing users to know what the most frequent request has been.

This endpoint should:

- Accept no parameter

- Return the parameters corresponding to the most used request, as well as the number of hits for this request

Don’t forget to add unit tests.

Please commit your project on Git and send me the url.

## Stack

- java 17
- spring boot 2.7.5 / gradle / docker + graalvm via Spring Native

## API

Les endpoints sont:

- /v1/fizzbuzz: renvoie un tableau
- /v1/fizzbuzz/statistic: renvoie la requête la plus appelée

> The project embarks the `springdoc-openapi-ui` dependency, so a swagger page is reachable at this page `http://localhost:8080/swagger-ui.html`.

## Install & run

Build the project:

```shell
./gradlew build
```

The project can be dockerized via

```shell
./gradlew clean bootBuildImage
```

and then run:

```shell
docker-compose up
```

## Remarques

- J'ai opté pour une architecture de code en couche "classique" et non du hexagonal car l'héxagone me paraissait "
  overkill" pour le test puisque pas de code métier
- Je me suis concentré plus sur la diversité des UT que leur exhaustivité.
- Pas besoin d'authorisation ici. Nous pouvons mettre en place un rate limiting mais ceci doit être fait au niveau du
  WAF
- Bien sur, dans un contexte d'équipe, des profiles spring aurait été créé (dev et prod)
