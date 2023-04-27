package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.StatisticEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatisticRepository extends JpaRepository<StatisticEndpoint, Long> {
    @Query("SELECT MAX(count),parameters FROM StatisticEndpoint")
    public Optional<StatisticEndpoint> findFirstByOrderByCountDesc();
}
