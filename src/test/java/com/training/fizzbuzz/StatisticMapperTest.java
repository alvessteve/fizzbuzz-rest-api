package com.training.fizzbuzz;

import com.training.fizzbuzz.model.StatisticEndpoint;
import com.training.fizzbuzz.repository.ParametersEntity;
import com.training.fizzbuzz.repository.StatisticEntity;
import com.training.fizzbuzz.repository.StatisticMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StatisticMapperTest {
    @Test
    void should_map_to_object() {
        ParametersEntity parameters = new ParametersEntity();
        parameters.setInt1(1);
        parameters.setInt2(2);
        parameters.setLimit(100);
        parameters.setStr1("str1");
        parameters.setStr2("str2");
        StatisticEntity statisticEntity = new StatisticEntity();
        statisticEntity.setParameters(parameters);
        statisticEntity.setCount(1);
        statisticEntity.setId(1L);

        StatisticEndpoint statisticEndpoint = StatisticMapper.fromEntity(statisticEntity);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, statisticEndpoint.getCount()),
                () -> Assertions.assertEquals(1, statisticEndpoint.getParameters().getInt1()),
                () -> Assertions.assertEquals(2, statisticEndpoint.getParameters().getInt2()),
                () -> Assertions.assertEquals(100, statisticEndpoint.getParameters().getLimit()),
                () -> Assertions.assertEquals("str1", statisticEndpoint.getParameters().getStr1()),
                () -> Assertions.assertEquals("str2", statisticEndpoint.getParameters().getStr2())
        );

    }
}
