package com.training.fizzbuzz.repository.mapper;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.repository.entity.FizzbuzzRequestStatisticsEntity;

public class FizzBuzzRequestStatisticEntityMapper {

    public static FizzBuzzRequestStatistic toModel(FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity) {
        return FizzBuzzRequestStatistic.builder()
                .parameters(fizzbuzzRequestStatisticsEntity.getParameters())
                .endpointName(fizzbuzzRequestStatisticsEntity.getEndpointName())
                .nbCalls(fizzbuzzRequestStatisticsEntity.getNbCalls())
                .build();
    }

    public static FizzbuzzRequestStatisticsEntity toEntity(FizzBuzzRequestStatistic fizzBuzzRequestStatistic) {
        return FizzbuzzRequestStatisticsEntity.builder()
                .endpointName(fizzBuzzRequestStatistic.getEndpointName())
                .nbCalls(fizzBuzzRequestStatistic.getNbCalls())
                .parameters(fizzBuzzRequestStatistic.getParameters())
                .build();
    }

}
