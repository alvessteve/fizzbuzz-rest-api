package com.training.fizzbuzz.model;

import com.training.fizzbuzz.exception.BadFormatFizzBuzzElementException;

public record FizzBuzzElement<T>(T element) {

    public FizzBuzzElement {
        if(!(element instanceof Integer) && !(element instanceof String))
            throw new BadFormatFizzBuzzElementException("Should be an Integer or String but is : " + element.getClass().getName());
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
