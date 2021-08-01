package com.training.fizzbuzz.filter;


import com.training.fizzbuzz.model.FizzBuzzRequestStatistic;
import com.training.fizzbuzz.service.FizzBuzzStatisticService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class StatisticFilter extends OncePerRequestFilter {

    private static final int MINIMAL_PARAM_ARRAY_LENGTH = 1;

    private final FizzBuzzStatisticService fizzBuzzStatisticService;

    public StatisticFilter(FizzBuzzStatisticService fizzBuzzStatisticService) {
        this.fizzBuzzStatisticService = fizzBuzzStatisticService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        FizzBuzzRequestStatistic fizzBuzzRequestStatistic = extractRequestData(request);
        fizzBuzzStatisticService.increment(fizzBuzzRequestStatistic);
        filterChain.doFilter(request, response);
    }

    private FizzBuzzRequestStatistic extractRequestData(HttpServletRequest request) {
        Map<String, String> finalParameterMap = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();

        parameterMap.forEach((param, valueArray) -> {
            String value = valueArray.length >= MINIMAL_PARAM_ARRAY_LENGTH ? valueArray[0] : "";
            finalParameterMap.put(param, value);
        });

        return FizzBuzzRequestStatistic.builder()
                .endpointName(request.getRequestURI())
                .parameters(finalParameterMap)
                .build();
    }
}

