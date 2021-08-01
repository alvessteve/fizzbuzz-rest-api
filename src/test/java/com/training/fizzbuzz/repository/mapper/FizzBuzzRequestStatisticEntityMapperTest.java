package com.training.fizzbuzz.repository.mapper;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.repository.entity.FizzbuzzRequestStatisticsEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.training.fizzbuzz.repository.mapper.FizzBuzzRequestStatisticEntityMapper.toModel;
import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzRequestStatisticEntityMapperTest {

    private final String endpointName = "ENDPOINT";
    private final int nbCalls = 2;
    private final String valueParam = "4";
    private final String int1 = "int1";

    @Test
    public void should_map_to_model() {

        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = FizzBuzzRequestStatistic.builder()
                .endpointName(endpointName)
                .nbCalls(nbCalls)
                .parameters(Collections.emptyMap())
                .build();

        FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity = FizzbuzzRequestStatisticsEntity.builder()
                .endpointName(endpointName)
                .nbCalls(nbCalls)
                .parameters(Collections.emptyMap())
                .build();

        FizzBuzzRequestStatistic result = toModel(fizzbuzzRequestStatisticsEntity);

        assertThat(result).isEqualTo(fizzBuzzRequestStatistic);

    }

    @Test
    public void should_map_to_entity() {
        FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity = FizzbuzzRequestStatisticsEntity.builder()
                .parameters(Collections.singletonMap(int1, valueParam))
                .nbCalls(nbCalls)
                .endpointName(endpointName)
                .build();


        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = FizzBuzzRequestStatistic.builder()
                .parameters(Collections.singletonMap(int1, valueParam))
                .nbCalls(nbCalls)
                .endpointName(endpointName)
                .build();

        FizzbuzzRequestStatisticsEntity result = FizzBuzzRequestStatisticEntityMapper.toEntity(fizzBuzzRequestStatistic);

        Assertions.assertThat(result).isEqualTo(fizzbuzzRequestStatisticsEntity);
    }

    @Test
    public void should_not_map_to_entity() {
        FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity = FizzbuzzRequestStatisticsEntity.builder()
                .parameters(Collections.singletonMap("int2", valueParam))
                .nbCalls(nbCalls)
                .endpointName(endpointName)
                .build();

        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = FizzBuzzRequestStatistic.builder()
                .parameters(Collections.singletonMap(int1, valueParam))
                .nbCalls(nbCalls)
                .endpointName(endpointName)
                .build();

        FizzbuzzRequestStatisticsEntity result = FizzBuzzRequestStatisticEntityMapper.toEntity(fizzBuzzRequestStatistic);

        Assertions.assertThat(result).isNotEqualTo(fizzbuzzRequestStatisticsEntity);
    }
}