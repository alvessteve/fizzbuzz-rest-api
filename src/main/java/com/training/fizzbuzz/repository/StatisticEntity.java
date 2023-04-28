package com.training.fizzbuzz.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "statistic")
public class StatisticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statistic_seq")
    @SequenceGenerator(name = "statistic_seq", sequenceName = "statistic_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "occurences")
    private int count;

    @Embedded
    private ParametersEntity parameters;

    public void increment(){
        count++;
    }

}
