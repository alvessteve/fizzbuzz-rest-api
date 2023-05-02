package com.training.fizzbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
    @Query("SELECT new StatisticEntity(id, MAX(count), parameters) FROM StatisticEntity GROUP BY parameters, id ORDER BY count DESC LIMIT 1")
    public Optional<StatisticEntity> findMostCalled();

    public Optional<StatisticEntity> findStatisticEntityByCountAndParameters(int count, ParametersEntity parameters);
}
