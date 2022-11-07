package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryFizzBuzzRepositoryTest {

    private final InMemoryFizzBuzzRepository inMemoryFizzBuzzRepository = new InMemoryFizzBuzzRepository();

    @BeforeEach
    public void init() {
        inMemoryFizzBuzzRepository.clean();
    }

    @Test
    public void should_clean_table() {
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity = generateOneFizzBuzzStatisticEntity(0, "endpoint");
        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity);
        inMemoryFizzBuzzRepository.clean();

        Optional<FizzBuzzRequestStatistic> previousEntity = inMemoryFizzBuzzRepository.findById(fizzbuzzRequestStatisticsEntity.hashCode());

        assertThat(previousEntity.isPresent()).isFalse();
    }

    @Test
    public void should_insert() {
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity1 = generateOneFizzBuzzStatisticEntity(1, "endpoint");

        Optional<FizzBuzzRequestStatistic> initialState = inMemoryFizzBuzzRepository.findById(fizzbuzzRequestStatisticsEntity1.hashCode());
        assertThat(initialState.isPresent()).isFalse();

        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity1);

        Optional<FizzBuzzRequestStatistic> finalState = inMemoryFizzBuzzRepository.findById(fizzbuzzRequestStatisticsEntity1.hashCode());
        assertThat(finalState.isPresent()).isTrue();
    }

    @Test
    public void should_not_find_by_id() {
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity1 = generateOneFizzBuzzStatisticEntity(1, "endpoint");
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity2 = generateOneFizzBuzzStatisticEntity(1, "endpoint2");
        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity1);

        Optional<FizzBuzzRequestStatistic> byId = inMemoryFizzBuzzRepository.findById(fizzbuzzRequestStatisticsEntity2.hashCode());

        assertThat(byId.isPresent()).isFalse();
    }

    @Test
    public void should_find_by_id() {
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity1 = generateOneFizzBuzzStatisticEntity(1, "endpoint");
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity2 = generateOneFizzBuzzStatisticEntity(1, "endpoint2");
        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity1);
        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity2);

        Optional<FizzBuzzRequestStatistic> byId = inMemoryFizzBuzzRepository.findById(fizzbuzzRequestStatisticsEntity2.hashCode());

        assertThat(byId.isPresent()).isTrue();
    }

    @Test
    public void should_find_most_used() {
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity1 = generateOneFizzBuzzStatisticEntity(1, "endpoint");
        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity2 = generateOneFizzBuzzStatisticEntity(3, "endpoint2");
        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity1);
        inMemoryFizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity2);

        Optional<FizzBuzzRequestStatistic> mostCalled = inMemoryFizzBuzzRepository.findMostCalled();

        assertThat(mostCalled.get()).isEqualTo(fizzbuzzRequestStatisticsEntity2);
    }


    private FizzBuzzRequestStatistic generateOneFizzBuzzStatisticEntity(int nbCalls, String endpointName) {
        return FizzBuzzRequestStatistic.builder()
                .nbCalls(nbCalls)
                .endpointName(endpointName)
                .parameters(Collections.emptyMap())
                .build();
    }
}