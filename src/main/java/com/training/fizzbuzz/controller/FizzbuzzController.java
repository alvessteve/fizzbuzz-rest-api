package com.training.fizzbuzz.controller;

import com.training.fizzbuzz.model.FizzBuzzArray;
import com.training.fizzbuzz.model.response.FizzBuzzArrayResponse;
import com.training.fizzbuzz.service.generator.FizzBuzzArrayGenerator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/v1/fizzbuzz")
public class FizzbuzzController {

    private final FizzBuzzArrayGenerator fizzBuzzArrayGenerator;

    public FizzbuzzController(FizzBuzzArrayGenerator fizzBuzzArrayGenerator) {
        this.fizzBuzzArrayGenerator = fizzBuzzArrayGenerator;
    }

    @GetMapping
    public FizzBuzzArrayResponse createList(
            @RequestParam @Min(1) Integer int1,
            @RequestParam @Min(1) Integer int2,
            @RequestParam @NotNull @Max(Integer.MAX_VALUE) Integer limit,
            @RequestParam @NotBlank String str1,
            @RequestParam @NotBlank String str2) {
        FizzBuzzArray fizzBuzzArray = fizzBuzzArrayGenerator.generateFizzbuzzList(int1, int2, limit, str1, str2);
        return new FizzBuzzArrayResponse(fizzBuzzArray.toString());
    }

    @GetMapping("/statistic")
    public void getMostUsed() {
        //To be implemented
    }
}
