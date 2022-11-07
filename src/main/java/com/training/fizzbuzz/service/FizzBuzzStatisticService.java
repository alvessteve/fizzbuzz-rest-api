package com.training.fizzbuzz.service;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.repository.FizzBuzzRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class FizzBuzzStatisticService {

    private final FizzBuzzRepository fizzBuzzRepository;

    public FizzBuzzStatisticService(FizzBuzzRepository fizzBuzzRepository) {
        this.fizzBuzzRepository = fizzBuzzRepository;
    }

    public FizzBuzzRequestStatistic mostRequested() {
        Optional<FizzBuzzRequestStatistic> optionalMostCalled = fizzBuzzRepository.findMostCalled();
        if (optionalMostCalled.isPresent()) {
            return optionalMostCalled.get();
        } else {
            return FizzBuzzRequestStatistic.empty();
        }
    }

    public void increment(FizzBuzzRequestStatistic fizzBuzzRequestStatistic) {
        Optional<FizzBuzzRequestStatistic> optionalFizzbuzzStatisticsDocument = fizzBuzzRepository.findById(fizzBuzzRequestStatistic.hashCode());

        FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity;

        if (optionalFizzbuzzStatisticsDocument.isPresent()) {
            fizzbuzzRequestStatisticsEntity = optionalFizzbuzzStatisticsDocument.get();
            fizzbuzzRequestStatisticsEntity.setNbCalls(fizzbuzzRequestStatisticsEntity.getNbCalls() + 1);
        } else {
            fizzbuzzRequestStatisticsEntity = fizzBuzzRequestStatistic;
            fizzbuzzRequestStatisticsEntity.setNbCalls(1);
        }

        fizzBuzzRepository.save(fizzbuzzRequestStatisticsEntity);
    }

}
