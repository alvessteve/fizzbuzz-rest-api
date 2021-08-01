package com.training.fizzbuzz.repository;

import com.training.fizzbuzz.repository.entity.FizzbuzzRequestStatisticsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class InMemoryFizzBuzzRepository implements FizzBuzzRepository {

    private ConcurrentHashMap<Integer, FizzbuzzRequestStatisticsEntity> occurences;

    public InMemoryFizzBuzzRepository() {
        this.occurences = new ConcurrentHashMap<>();
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
            log.info("empty map so returning an empty one");
            return Optional.empty();
        }

        FizzbuzzRequestStatisticsEntity result = occurences.values().stream().findFirst().get();

        // Not "stream" because much more easier to write/read/maintain than streams in my opinion
        for (FizzbuzzRequestStatisticsEntity fizzbuzzRequestStatisticsEntity : occurences.values()) {
            if (fizzbuzzRequestStatisticsEntity.getNbCalls() > result.getNbCalls()) {
                result = fizzbuzzRequestStatisticsEntity;
            }
        }

        log.info("found " + result + " as the most requested endpoint");
        return Optional.of(result);
    }

    @Override
    public void clean() {
        occurences = new ConcurrentHashMap<>();
    }
}
