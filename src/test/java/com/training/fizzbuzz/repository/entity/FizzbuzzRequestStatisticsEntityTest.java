package com.training.fizzbuzz.repository.entity;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.training.fizzbuzz.repository.mapper.FizzBuzzRequestStatisticEntityMapper.toModel;
import static org.assertj.core.api.Assertions.assertThat;

class FizzbuzzRequestStatisticsEntityTest {

    @Test
    public void should_not_be_equal() {
        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = FizzBuzzRequestStatistic.builder()
                .endpointName("TOTO")
                .nbCalls(1)
                .parameters(Collections.emptyMap())
                .build();

        FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity = FizzbuzzRequestStatisticsEntity.builder()
                .endpointName("TATA")
                .nbCalls(1)
                .parameters(Collections.emptyMap())
                .build();

        FizzBuzzRequestStatistic result = toModel(fizzbuzzRequestStatisticsEntity);

        assertThat(result).isNotEqualTo(fizzBuzzRequestStatistic);
    }

}