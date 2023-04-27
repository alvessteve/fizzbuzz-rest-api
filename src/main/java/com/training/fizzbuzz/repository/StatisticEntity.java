package com.training.fizzbuzz.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "statistic")
public class StatisticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "occurences")
    private int count;

    @Embedded
    private ParametersEntity parameters;

}
