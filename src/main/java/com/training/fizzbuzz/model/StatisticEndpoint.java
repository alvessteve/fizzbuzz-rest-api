package com.training.fizzbuzz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "statistic")
@AllArgsConstructor
@NoArgsConstructor
public class StatisticEndpoint {

    public StatisticEndpoint(Parameters parameters, int count) {
        this.parameters = parameters;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Parameters parameters;

    @Column(name = "occurences")
    private int count;
}
