package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.repository.entity.FizzbuzzRequestStatisticsEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Test double du repository pour les tests.
 * On n'utilise plus une concurrentHashMap mais une simple hashMap
 */
public class InMemoryFizzBuzzRepositoryForTesting implements FizzBuzzRepository {

    private Map<Integer, FizzbuzzRequestStatisticsEntity> occurences;

    public InMemoryFizzBuzzRepositoryForTesting() {
        this.occurences = new HashMap<>();
    }

    @Override
    public Optional<FizzbuzzRequestStatisticsEntity> findById(int hashCode) {
        return Optional.ofNullable(occurences.get(hashCode));
    }

    @Override
    public void save(FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity) {
        int hashCode = fizzbuzzRequestStatisticsEntity.hashCode();
        occurences.remove(hashCode);
        occurences.put(hashCode, fizzbuzzRequestStatisticsEntity);
    }

    @Override
    public Optional<FizzbuzzRequestStatisticsEntity> findMostCalled() {
        if (occurences.isEmpty()) {
            return Optional.empty();
        }

        FizzbuzzRequestStatisticsEntity result = occurences.values().stream().findFirst().get();

        // Not "java 8" but much more easier to write/read/maintain than streams
        for (FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity : occurences.values()) {
            if (fizzbuzzRequestStatisticsEntity.getNbCalls() > result.getNbCalls()) {
                result = fizzbuzzRequestStatisticsEntity;
            }
        }

        return Optional.ofNullable(result);
    }

    @Override
    public void clean() {
        occurences = new ConcurrentHashMap<>();
    }
}
