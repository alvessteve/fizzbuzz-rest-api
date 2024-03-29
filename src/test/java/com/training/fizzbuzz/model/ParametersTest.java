package com.training.fizzbuzz.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParametersTest {

    @Test
    void should_create_parameters_object() {
        var parameters = new Parameters(1,2,10,"st", "sto");

        assertThat(parameters).isNotNull();
        assertThat(parameters.getInt1()).isEqualTo(1);
        assertThat(parameters.getInt2()).isEqualTo(2);
        assertThat(parameters.getLimit()).isEqualTo(10);
        assertThat(parameters.getStr1()).isEqualTo("st");
        assertThat(parameters.getStr2()).isEqualTo("sto");
    }

}
