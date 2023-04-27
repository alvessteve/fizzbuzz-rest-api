package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.Parameters;
import com.training.fizzbuzz.model.StatisticEndpoint;

public class StatisticMapper {
    public static StatisticEndpoint fromEntity(StatisticEntity statisticEntity){

        var parametersEntity = statisticEntity.getParameters();

        return StatisticEndpoint.builder()
                .parameters(new Parameters(
                        parametersEntity.getInt1(),
                        parametersEntity.getInt2(),
                        parametersEntity.getLimit(),
                        parametersEntity.getStr1(),
                        parametersEntity.getStr2())
                )
                .count(statisticEntity.getCount())
                .build();
    }
}
