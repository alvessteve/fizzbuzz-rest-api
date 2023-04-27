package com.training.fizzbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
    @Query("SELECT MAX(count),parameters FROM StatisticEntity GROUP BY parameters")
    public Optional<StatisticEntity> findFirstByOrderByCountDesc();
}
