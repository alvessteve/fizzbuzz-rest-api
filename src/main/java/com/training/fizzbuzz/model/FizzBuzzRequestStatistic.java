package com.training.fizzbuzz.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@Builder
public class FizzBuzzRequestStatistic {
    private String endpointName;
    private int nbCalls;
    private Map<String, String> parameters;

    public static FizzBuzzRequestStatistic empty() {
        return FizzBuzzRequestStatistic.builder().build();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizzBuzzRequestStatistic that = (FizzBuzzRequestStatistic) o;
        return nbCalls == that.nbCalls && Objects.equals(endpointName, that.endpointName) && Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpointName, parameters);
    }
}
