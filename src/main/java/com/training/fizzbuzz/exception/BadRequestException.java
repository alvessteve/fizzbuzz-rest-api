package com.training.fizzbuzz.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BadRequestException {
    private String errorMessage;

    @Override
    public String toString() {
        return "{ \"errorMessage\": \"" + errorMessage + "\"}";
    }
}
