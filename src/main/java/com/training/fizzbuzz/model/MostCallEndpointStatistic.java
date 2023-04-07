package com.training.fizzbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MostCallEndpointStatistic {

    public MostCallEndpointStatistic(Parameters parameters, int count) {
        this.parameters = parameters;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Parameters parameters;

    private int count;
}