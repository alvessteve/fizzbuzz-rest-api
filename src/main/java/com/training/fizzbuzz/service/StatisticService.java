package com.training.fizzbuzz.service;

import com.training.fizzbuzz.model.StatisticEndpoint;
import com.training.fizzbuzz.repository.StatisticEntity;
import com.training.fizzbuzz.repository.StatisticMapper;
import com.training.fizzbuzz.repository.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public StatisticEndpoint findMostCalledEndpoint() {
        return statisticRepository.findFirstByOrderByCountDesc()
                .map(StatisticMapper::fromEntity)
                .orElse(new StatisticEndpoint());
    }

    public void saveStatisticParameters(StatisticEndpoint statisticEndpoint){
        var incomingStastisticEntity = StatisticMapper.fromModelObject(statisticEndpoint);
        Optional<StatisticEntity> optionalExistingStatisticEntity = statisticRepository.findStatisticEntityByCountAndParameters(statisticEndpoint.getCount(), incomingStastisticEntity.getParameters());
        optionalExistingStatisticEntity.ifPresent(StatisticEntity::increment);
        statisticRepository.save(optionalExistingStatisticEntity.orElse(incomingStastisticEntity));
    }
}
