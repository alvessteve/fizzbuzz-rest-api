package com.training.fizzbuzz;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzbuzzApiApplicationTests {

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
	}

	@Test
	void should_return_200_for_fizzbuzz_with_correct_array() {
		get("/v1/fizzbuzz?int1=3&int2=5&limit=16&str1=fizz&str2=buzz")
				.then()
				.statusCode(200)
				.assertThat()
				.body("elements", equalTo("[1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16]"));
	}

	@Test
	void should_return_400_for_wrong_parameters() {
		get("/v1/fizzbuzz?int1=0&int2=5&limit=16&str1=fizz&str2=buzz")
				.then()
				.statusCode(400)
				.assertThat()
				.body("message", equalTo("com.training.fizzbuzz.exception.BadRequestException: createList.int1: doit être supérieur ou égal à 1"));
	}
}
