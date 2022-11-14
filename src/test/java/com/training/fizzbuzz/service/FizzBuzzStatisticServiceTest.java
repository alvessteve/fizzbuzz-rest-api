package com.training.fizzbuzz.service;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.repository.FizzBuzzRepository;
import com.training.fizzbuzz.repository.InMemoryFizzBuzzRepositoryForTesting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

/**
 * Dans ce contexte, le repository est un test double de type en mémoire. Le but n'est pas de faire un test d'intégration mais de tester le service avec
 * une implémentation "en mémoire" du repository.
 * <p>
 * Une autre méthode possible serait d'utiliser un mock, de mocker le repository est de vérifier si l'appel est fait avec telle entitée. Néanmoins, je préfère la première
 * méthode car cela évite de tester des détail d'implémentation.
 **/
class FizzBuzzStatisticServiceTest {

    private static FizzBuzzStatisticService fizzBuzzStatisticService;
    private static FizzBuzzRepository fizzBuzzRepository;

    @BeforeAll
    static void init() {
        fizzBuzzRepository = new InMemoryFizzBuzzRepositoryForTesting();
        fizzBuzzStatisticService = new FizzBuzzStatisticService(fizzBuzzRepository);
    }

    @BeforeEach
    public void setup() {
        fizzBuzzRepository.clean();
    }

    @Test
    public void should_increment_to_1_a_new_query() {

        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = FizzBuzzRequestStatistic.builder()
                .endpointName("endpoint")
                .parameters(Collections.singletonMap("int1", "toto"))
                .build();


        fizzBuzzStatisticService.increment(fizzBuzzRequestStatistic);

        Optional<FizzBuzzRequestStatistic> fizzbuzzRequestStatisticsEntity = fizzBuzzRepository.findById(fizzBuzzRequestStatistic.hashCode());

        Assertions.assertThat(fizzbuzzRequestStatisticsEntity.isPresent()).isTrue();
        Assertions.assertThat(fizzbuzzRequestStatisticsEntity.get().getNbCalls()).isEqualTo(1);
    }

    @Test
    public void should_increment_existing_request() {
        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = FizzBuzzRequestStatistic.builder()
                .endpointName("endpoint")
                .nbCalls(2)
                .parameters(Collections.singletonMap("int1", "toto"))
                .build();
        fizzBuzzRepository.save(fizzBuzzRequestStatistic);
        fizzBuzzStatisticService.increment(fizzBuzzRequestStatistic);

        Optional<FizzBuzzRequestStatistic> fizzbuzzRequestStatisticsEntity = fizzBuzzRepository.findById(fizzBuzzRequestStatistic.hashCode());

        Assertions.assertThat(fizzbuzzRequestStatisticsEntity.isPresent()).isTrue();
        Assertions.assertThat(fizzbuzzRequestStatisticsEntity.get().getNbCalls()).isEqualTo(3);
    }
}