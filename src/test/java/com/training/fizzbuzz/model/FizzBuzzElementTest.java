package com.training.fizzbuzz.model;

import com.training.fizzbuzz.exception.BadFormatFizzBuzzElementException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzElementTest {

    @Test
    void should_create_fizzbuzzelement_from_string() {
        var helloWorld = "helloworld";
        FizzBuzzElement<String> fizzBuzzElement = new FizzBuzzElement<>(helloWorld);
        assertThat(fizzBuzzElement.element()).isEqualTo(helloWorld);
    }

    @Test
    void should_create_fizzbuzzelement_from_integers() {
        var elementInt = 12;
        FizzBuzzElement<Integer> fizzBuzzElement = new FizzBuzzElement<>(elementInt);
        assertThat(fizzBuzzElement.element()).isEqualTo(elementInt);
    }

    @Test
    public void should_return_badformatexception_for_various_types() {

        List<Object> sourceValues = List.of(1L, Double.valueOf(156), 'c', true);

        sourceValues.forEach(value -> assertThrows(BadFormatFizzBuzzElementException.class, () -> new FizzBuzzElement<>(value)));
    }
}