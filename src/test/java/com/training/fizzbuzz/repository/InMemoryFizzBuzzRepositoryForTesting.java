package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Test double du repository pour les tests.
 * On n'utilise plus une concurrentHashMap mais une simple hashMap
 */
public class InMemoryFizzBuzzRepositoryForTesting implements FizzBuzzRepository {

    private Map<Integer, FizzBuzzRequestStatistic> occurences;

    public InMemoryFizzBuzzRepositoryForTesting() {
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
            return Optional.empty();
        }

        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = occurences.values()
                .stream()
                .max(FizzBuzzRequestStatistic::compareTo)
                .orElse(FizzBuzzRequestStatistic.empty());

        return Optional.of(fizzBuzzRequestStatistic);
    }

    @Override
    public void clean() {
        occurences = new ConcurrentHashMap<>();
    }
}
