package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.MostCallEndpointStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<MostCallEndpointStatistic, Long> {
    public MostCallEndpointStatistic findTopByCount();
}
