package com.training.fizzbuzz.controller;

import com.training.fizzbuzz.model.FizzBuzzArray;
import com.training.fizzbuzz.model.Parameters;
import com.training.fizzbuzz.model.StatisticEndpoint;
import com.training.fizzbuzz.model.response.FizzBuzzArrayResponse;
import com.training.fizzbuzz.model.response.MostCalledEndpointResponse;
import com.training.fizzbuzz.service.StatisticService;
import com.training.fizzbuzz.service.generator.FizzBuzzArrayGenerator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/v1/fizzbuzz")
public class FizzbuzzController {

    private final FizzBuzzArrayGenerator fizzBuzzArrayGenerator;

    private final StatisticService statisticService;

    public FizzbuzzController(FizzBuzzArrayGenerator fizzBuzzArrayGenerator, StatisticService statisticService) {
        this.fizzBuzzArrayGenerator = fizzBuzzArrayGenerator;
        this.statisticService = statisticService;
    }

    @GetMapping
    public FizzBuzzArrayResponse createList(
            @RequestParam @Min(1) Integer int1,
            @RequestParam @Min(1) Integer int2,
            @RequestParam @NotNull @Max(Integer.MAX_VALUE) Integer limit,
            @RequestParam @NotBlank String str1,
            @RequestParam @NotBlank String str2) {
        var statisticEndpoint = new StatisticEndpoint(new Parameters(int1, int2, limit, str1, str2), 1);
        statisticService.saveStatisticParameters(statisticEndpoint);
        FizzBuzzArray fizzBuzzArray = fizzBuzzArrayGenerator.generateFizzbuzzList(int1, int2, limit, str1, str2);
        return new FizzBuzzArrayResponse(fizzBuzzArray.toString());
    }

    @GetMapping("/statistic")
    public MostCalledEndpointResponse getMostUsed() {
        StatisticEndpoint mostCalledEndpoint = statisticService.findMostCalledEndpoint();
        return new MostCalledEndpointResponse(mostCalledEndpoint);
    }
}
