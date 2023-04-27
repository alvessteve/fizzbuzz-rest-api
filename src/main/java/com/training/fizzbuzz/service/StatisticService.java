package com.training.fizzbuzz.service;

import com.training.fizzbuzz.model.StatisticEndpoint;
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

    public StatisticEndpoint findMostCalledEndpoint() {
        return statisticRepository.findFirstByOrderByCountDesc().orElse(new StatisticEndpoint());
    }
}
