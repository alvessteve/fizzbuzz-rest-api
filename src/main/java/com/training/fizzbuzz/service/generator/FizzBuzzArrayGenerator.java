package com.training.fizzbuzz.service.generator;

import com.training.fizzbuzz.model.FizzBuzzArray;
import com.training.fizzbuzz.model.FizzBuzzElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.training.fizzbuzz.service.generator.ModuloUtils.isModulo;

@Slf4j
@Service
public class FizzBuzzArrayGenerator {

    public FizzBuzzArray generateFizzbuzzList(int int1, int int2, int limit, String str1, String str2) {
        checkArguments(int1, int2);

        List<FizzBuzzElement<?>> elements = IntStream.rangeClosed(1, limit)
                .mapToObj(value -> checkModulo(int1, int2, str1, str2, value))
                .collect(Collectors.toList());

        return new FizzBuzzArray(elements);
    }

    private void checkArguments(int int1, int int2) {
        if (int1 == 0 || int2 == 0) {
            log.error("[ERROR] int1 = " + int1 + " or int2 = " + int2 + " is null");
            throw new IllegalArgumentException("int1 or int2 should'nt be equal to zero");
        }
    }

    private FizzBuzzElement<?> checkModulo(int int1, int int2, String str1, String str2, int i) {
        if (isModulo(i, int1 * int2)) {
            return new FizzBuzzElement<>(str1 + str2);
        } else if (isModulo(i, int2)) {
            return new FizzBuzzElement<>(str2);
        } else if (isModulo(i, int1)) {
            return new FizzBuzzElement<>(str1);
        } else {
            return new FizzBuzzElement<>(i);
        }
    }
}
