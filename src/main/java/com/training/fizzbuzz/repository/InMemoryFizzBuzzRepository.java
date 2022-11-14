package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Repository
public class InMemoryFizzBuzzRepository implements FizzBuzzRepository {

    private HashMap<Integer, FizzBuzzRequestStatistic> occurences;

    public InMemoryFizzBuzzRepository() {
        this.occurences = new HashMap<>();
    }

    @Override
    public Optional<FizzBuzzRequestStatistic> findById(int hashCode) {
        return Optional.ofNullable(occurences.get(hashCode));
    }

    @Override
    public void save(FizzBuzzRequestStatistic fizzbuzzRequestStatisticsEntity) {
        int hashCode = fizzbuzzRequestStatisticsEntity.hashCode();
        occurences.remove(hashCode);
        occurences.put(hashCode, fizzbuzzRequestStatisticsEntity);
    }

    @Override
    public Optional<FizzBuzzRequestStatistic> findMostCalled() {
        if (occurences.isEmpty()) {
            log.info("empty map so returning an empty one");
            return Optional.empty();
        }

        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = occurences.values()
                .stream()
                .max(FizzBuzzRequestStatistic::compareTo)
                .orElse(FizzBuzzRequestStatistic.empty());

        log.info("found " + fizzBuzzRequestStatistic + " as the most requested endpoint");
        return Optional.of(fizzBuzzRequestStatistic);
    }

    @Override
    public void clean() {
        occurences = new HashMap<>();
    }
}
