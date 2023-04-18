package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.StatisticEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatisticRepository extends JpaRepository<StatisticEndpoint, Long> {
    public Optional<StatisticEndpoint> findFirstByOrderByCountDesc();
}
