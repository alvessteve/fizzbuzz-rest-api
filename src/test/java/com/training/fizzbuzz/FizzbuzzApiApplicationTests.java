package com.training.fizzbuzz;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzbuzzApiApplicationTests {

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	void should_return_200_for_fizzbuzz_with_correct_array() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		given()
				.port(port)
				.get("/v1/fizzbuzz?int1=3&int2=5&limit=16&str1=fizz&str2=buzz")
				.then()
				.statusCode(200)
				.assertThat()
				.body("elements", equalTo("[1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16]"));
	}
}
