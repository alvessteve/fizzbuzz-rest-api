package com.training.fizzbuzz.service;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.repository.FizzBuzzRepository;
import com.training.fizzbuzz.repository.entity.FizzbuzzRequestStatisticsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.training.fizzbuzz.repository.mapper.FizzBuzzRequestStatisticEntityMapper.toEntity;
import static com.training.fizzbuzz.repository.mapper.FizzBuzzRequestStatisticEntityMapper.toModel;

@Slf4j
@Service
public class FizzBuzzStatisticService {

    private final FizzBuzzRepository fizzBuzzRepository;

    public FizzBuzzStatisticService(FizzBuzzRepository fizzBuzzRepository) {
        this.fizzBuzzRepository = fizzBuzzRepository;
    }

    public FizzBuzzRequestStatistic mostRequested() {
        Optional<FizzbuzzRequestStatisticsEntity> optionalMostCalled = fizzBuzzRepository.findMostCalled();
        if (optionalMostCalled.isPresent()) {
            return toModel(optionalMostCalled.get());
        } else {
            return FizzBuzzRequestStatistic.empty();
        }
    }

    public void increment(FizzBuzzRequestStatistic fizzBuzzRequestStatistic) {
        Optional<FizzbuzzRequestStatisticsEntity> optionalFizzbuzzStatisticsDocument = fizzBuzzRepository.findById(fizzBuzzRequestStatistic.hashCode());

        FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity;

        if (optionalFizzbuzzStatisticsDocument.isPresent()) {
            fizzbuzzRequestStatisticsEntity = optionalFizzbuzzStatisticsDocument.get();
            fizzbuzzRequestStatisticsEntity.setNbCalls(fizzbuzzRequestStatisticsEntity.getNbCalls() + 1);
        } else {
            fizzbuzzRequestStatisticsEntity = toEntity(fizzBuzzRequestStatistic);
            fizzbuzzRequestStatisticsEntity.setNbCalls(1);
        }

        fizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity);
    }

}
