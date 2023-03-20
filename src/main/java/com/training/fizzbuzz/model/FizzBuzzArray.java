package com.training.fizzbuzz.model;

import java.util.Collection;

public record FizzBuzzArray(Collection<FizzBuzzElement<?>> elements) {

    @Override
    public String toString() {
        return elements.toString();
    }
}
