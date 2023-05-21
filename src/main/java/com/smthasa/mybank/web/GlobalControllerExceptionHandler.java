package com.smthasa.mybank.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smthasa.mybank.dto.ErrorDto;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> validationFailures = new ArrayList<String>();
        for (FieldError error : e.getFieldErrors()) {
            validationFailures.add(error.getField());
        }
        return new ErrorDto(e.getMessage(), validationFailures);
    }
}
