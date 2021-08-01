package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.repository.entity.FizzbuzzRequestStatisticsEntity;

import java.util.Optional;

public interface FizzBuzzRepository {
    Optional<FizzbuzzRequestStatisticsEntity> findById(int hashCode);

    void save(FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity);

    Optional<FizzbuzzRequestStatisticsEntity> findMostCalled();

    void clean();
}
