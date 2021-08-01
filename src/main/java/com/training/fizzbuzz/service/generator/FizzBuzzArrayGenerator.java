package com.training.fizzbuzz.service.generator;

import com.training.fizzbuzz.model.FizzBuzzArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.training.fizzbuzz.service.generator.ModuloUtils.isModulo;

@Slf4j
@Service
public class FizzBuzzArrayGenerator {

    public FizzBuzzArray generateFizzbuzzList(int int1, int int2, int limit, String str1, String str2) {
        checkArguments(int1, int2);

        List<Object> fizzbuzzList = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            checkModuloAndFill(int1, int2, str1, str2, fizzbuzzList, i);
        }

        return new FizzBuzzArray(fizzbuzzList);
    }

    private void checkArguments(int int1, int int2) {
        if (int1 == 0 || int2 == 0) {
            log.error("[ERROR] int1 = " + int1 + " or int2 = " + int2 + " is null");
            throw new IllegalArgumentException("int1 or int2 should'nt be equal to zero");
        }
    }

    private void checkModuloAndFill(int int1, int int2, String str1, String str2, List<Object> fizzbuzzList, int i) {
        if (isModulo(i, int1 * int2)) {
            fizzbuzzList.add(str1 + str2);
        } else if (isModulo(i, int2)) {
            fizzbuzzList.add(str2);
        } else if (isModulo(i, int1)) {
            fizzbuzzList.add(str1);
        } else {
            fizzbuzzList.add(i);
        }
    }
}
