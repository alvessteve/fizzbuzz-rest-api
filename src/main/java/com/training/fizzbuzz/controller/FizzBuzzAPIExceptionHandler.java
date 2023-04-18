package com.training.fizzbuzz.controller;

import com.training.fizzbuzz.exception.BadRequestException;
import com.training.fizzbuzz.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class FizzBuzzAPIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, ConstraintViolationException.class})
    protected ResponseEntity<ErrorResponse> handleBadRequestException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = new BadRequestException(ex.getLocalizedMessage()).toString();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(bodyOfResponse));
    }

}
