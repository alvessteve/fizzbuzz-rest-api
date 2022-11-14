package com.training.fizzbuzz.model;

import lombok.*;

import java.util.Map;

@Data
@Builder
public class FizzBuzzRequestStatistic implements Comparable<FizzBuzzRequestStatistic> {
    private String endpointName;
    private int nbCalls;
    private Map<String, String> parameters;

    public static FizzBuzzRequestStatistic empty() {
        return FizzBuzzRequestStatistic.builder().build();
    }

    @Override
    public int compareTo(FizzBuzzRequestStatistic o) {
        if(o.getNbCalls() == this.getNbCalls()) {
            return 0;
        }
        return this.getNbCalls() > o.getNbCalls() ? 1 : -1;
    }
}
