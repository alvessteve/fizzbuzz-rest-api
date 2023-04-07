package com.training.fizzbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Parameters {

    private int int1;
    private int int2;
    private int limit;

    private String str1;

    private String str2;
}
