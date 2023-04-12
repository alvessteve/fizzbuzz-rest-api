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

Then the project can be dockerized

```shell
./gradlew bootBuildImage
```

and then run:

```shell
docker-compose up
```


## Remarques

- J'ai opté pour une architecture de code en couche "classique" et non du hexagonal car l'héxagone me paraissait "
  overkill" pour le test puisque peu de code métier
- Je n'ai pas visé les 100% de coverage UT, par manque de temps principalement. Ainsi, je me suis concentré plus sur la
  diversité des UT que leur exhaustivité.
- J'ai ajouté le plus de commentaires dans le code pour expliquer les choix.
- Je n'ai pu faire des test d'intégration (en utilisant RestAssured) mais dans un contexte de mise en prod. Il aurait
  été présent et intégré à la pipeline CI.
- J'ai opté pour une implémentation "en mémoire" mano et non l'utilisation d'une base de données pour la persistence des
  requêtes. Principalement, pour gagner du temps et je considérais que ce n'était ce qui était le plus porteur de valeur
  dans le test (beaucoup de boilerplate: classe de configuration, client, docker-compose avec les 2 bases - 1 pour les
  tests d'intégration et une autre pour le fonctionnement normal -).
- Pas besoin d'authorisation ici. Nous pouvons mettre en place un rate limiting mais ceci doit être fait au niveau du
  WAF
- Bien sur, dans un contexte d'équipe, des profiles spring aurait été créé (dev et prod)
