package com.training.fizzbuzz.service.generator;

import com.training.fizzbuzz.model.FizzBuzzArray;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzArrayGeneratorTest {

    private final FizzBuzzArrayGenerator fizzBuzzArrayGenerator = new FizzBuzzArrayGenerator();

    @Test
    public void should_return_array() {
        List<Object> result = List.of(1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11, "fizz", 13, 14, "fizzbuzz", 16);

        FizzBuzzArray fizzBuzzArray = fizzBuzzArrayGenerator.generateFizzbuzzList(3, 5, 16, "fizz", "buzz");

        assertThat(fizzBuzzArray.result()).isEqualTo(result);
    }

    @Test
    public void should_throw_exception_because_division_by_zero_for_int1() {
        assertThatThrownBy(() -> fizzBuzzArrayGenerator.generateFizzbuzzList(0, 2, 5, "fizz", "buzz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("int1 or int2 should'nt be equal to zero");

    }

    @Test
    public void should_throw_exception_because_division_by_zero_for_int2() {
        assertThatThrownBy(() -> fizzBuzzArrayGenerator.generateFizzbuzzList(1, 0, 5, "fizz", "buzz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("int1 or int2 should'nt be equal to zero");

    }

    @Test
    public void should_return_empty_array_if_limit_is_zero() {
        FizzBuzzArray fizzBuzzArray = fizzBuzzArrayGenerator.generateFizzbuzzList(3, 5, 0, "fizz", "buzz");

        assertThat(fizzBuzzArray.result()).isEqualTo(Collections.emptyList());
    }

}