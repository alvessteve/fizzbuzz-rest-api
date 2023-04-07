package com.training.fizzbuzz.service;

import com.training.fizzbuzz.model.MostCallEndpointStatistic;
import com.training.fizzbuzz.repository.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public MostCallEndpointStatistic findMostCalledEndpoint() {
        return statisticRepository.findTopByCount();
    }
}
