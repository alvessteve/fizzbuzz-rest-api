package com.training.fizzbuzz.controller;

import com.training.fizzbuzz.model.FizzBuzzArray;
import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.service.FizzBuzzStatisticService;
import com.training.fizzbuzz.service.generator.FizzBuzzArrayGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fizzbuzz")
public class FizzbuzzController {

    private final FizzBuzzStatisticService fizzbuzzStatisticService;
    private final FizzBuzzArrayGenerator fizzBuzzArrayGenerator;

    public FizzbuzzController(FizzBuzzStatisticService fizzbuzzStatisticService, FizzBuzzArrayGenerator fizzBuzzArrayGenerator) {
        this.fizzbuzzStatisticService = fizzbuzzStatisticService;
        this.fizzBuzzArrayGenerator = fizzBuzzArrayGenerator;
    }

    @GetMapping
    public FizzBuzzArray createList(
            @RequestParam Integer int1,
            @RequestParam Integer int2,
            @RequestParam Integer limit,
            @RequestParam String str1,
            @RequestParam String str2) {
        return fizzBuzzArrayGenerator.generateFizzbuzzList(int1, int2, limit, str1, str2);
    }

    @GetMapping("/statistic")
    public FizzBuzzRequestStatistic getMostUsed() {
        return fizzbuzzStatisticService.mostRequested();
    }
}
