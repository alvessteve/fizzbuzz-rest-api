package com.training.fizzbuzz.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MostCallEndpointStatisticTest {

    @Test
    void should_have_parameters() {
        var parameters = new Parameters(1,2,10,"st", "sto");
        var mostCallEndpointStatistic = new MostCallEndpointStatistic(parameters, 0);

        assertThat(mostCallEndpointStatistic.getParameters()).isNotNull();
        assertThat(mostCallEndpointStatistic.getParameters()).isEqualTo(parameters);
    }

    @Test
    void should_have_count() {
        var parameters = new Parameters(1,2,10,"st", "sto");
        var mostCallEndpointStatistic = new MostCallEndpointStatistic(parameters, 2);

        assertThat(mostCallEndpointStatistic.getCount()).isEqualTo(2);
    }
}
