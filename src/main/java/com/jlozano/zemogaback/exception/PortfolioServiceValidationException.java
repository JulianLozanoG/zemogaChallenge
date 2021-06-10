package com.jlozano.zemogaback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PortfolioServiceValidationException extends RuntimeException {
    public PortfolioServiceValidationException(String message) {
        super(message);
    }
}
