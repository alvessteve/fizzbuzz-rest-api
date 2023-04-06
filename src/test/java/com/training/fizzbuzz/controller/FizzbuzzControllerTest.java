package com.training.fizzbuzz.controller;

import com.training.fizzbuzz.model.FizzBuzzArray;
import com.training.fizzbuzz.service.generator.FizzBuzzArrayGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.EMPTY_LIST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FizzbuzzController.class)
class FizzbuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzArrayGenerator fizzBuzzArrayGenerator;


    @Test
    void should_return_400_status_when_int1_parameter_invalid() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?int1=0&int2=3&limit=100&str1=toto&str2=toto"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_400_status_when_limit_parameter_invalid() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?int1=0&int2=3&limit=1000000000000000000&str1=toto&str2=toto"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_400_status_when_str1_parameter_invalid() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?int1=0&int2=3&limit=100&str1=&str2=toto"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_400_status_when_missing_parameter() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?int2=3&limit=100&str1=toto&str2=toto"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_200_status() throws Exception {
        Mockito.when(fizzBuzzArrayGenerator.generateFizzbuzzList(3,5,100,"fizz", "buzz"))
                .thenReturn(new FizzBuzzArray(EMPTY_LIST));
        mockMvc.perform(get("/v1/fizzbuzz?int1=3&int2=5&limit=100&str1=fizz&str2=buzz"))
                .andExpect(status().isOk());
    }
}
