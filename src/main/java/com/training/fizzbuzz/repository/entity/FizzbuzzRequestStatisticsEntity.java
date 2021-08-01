package com.training.fizzbuzz.repository.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@Builder
public class FizzbuzzRequestStatisticsEntity {
    private String endpointName;
    private int nbCalls;
    private Map<String, String> parameters;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizzbuzzRequestStatisticsEntity that = (FizzbuzzRequestStatisticsEntity) o;
        return nbCalls == that.nbCalls && Objects.equals(endpointName, that.endpointName) && Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpointName, parameters);
    }
}
