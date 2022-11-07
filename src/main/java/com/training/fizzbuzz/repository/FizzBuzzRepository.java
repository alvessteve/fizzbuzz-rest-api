package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;

import java.util.Optional;

public interface FizzBuzzRepository {
    Optional<FizzBuzzRequestStatistic> findById(int hashCode);

    void save(FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity);

    Optional<FizzBuzzRequestStatistic> findMostCalled();

    void clean();
}
