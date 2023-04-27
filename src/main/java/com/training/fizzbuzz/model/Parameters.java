package com.training.fizzbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Parameters {

    @Column(name = "first_integer")
    private int int1;
    @Column(name = "second_integer")
    private int int2;
    @Column(name = "max_limit")
    private int limit;

    private String str1;

    private String str2;
}
