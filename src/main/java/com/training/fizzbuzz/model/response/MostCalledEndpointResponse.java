package com.training.fizzbuzz.model.response;

import com.training.fizzbuzz.model.StatisticEndpoint;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MostCalledEndpointResponse {
    private StatisticEndpoint endpoint;
}
