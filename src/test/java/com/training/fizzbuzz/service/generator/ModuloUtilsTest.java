package com.training.fizzbuzz.service.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ModuloUtilsTest {

    @Test
    public void should_be_modulo_O() {
        boolean modulo = ModuloUtils.isModulo(4, 1);

        Assertions.assertThat(modulo).isEqualTo(true);
    }

    @Test
    public void should_not_be_modulo_O() {
        boolean modulo = ModuloUtils.isModulo(1, 4);

        Assertions.assertThat(modulo).isEqualTo(false);
    }
}