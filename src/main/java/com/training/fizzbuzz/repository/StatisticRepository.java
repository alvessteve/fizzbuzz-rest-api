package com.training.fizzbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
    @Query("SELECT new StatisticEntity(id, MAX(count), parameters) FROM StatisticEntity GROUP BY parameters, id ORDER BY count DESC LIMIT 1")
    Optional<StatisticEntity> findMostCalled();

    Optional<StatisticEntity> findStatisticEntityByParameters(ParametersEntity parameters);
}
