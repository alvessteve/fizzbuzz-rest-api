package com.training.fizzbuzz.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ParametersEntity {

    @Column(name = "first_integer")
    private int int1;
    @Column(name = "second_integer")
    private int int2;
    @Column(name = "max_limit")
    private int limit;

    private String str1;

    private String str2;
}
