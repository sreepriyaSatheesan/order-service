package com.foodhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OrderUpdateException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public OrderUpdateException(String s) {
        super(s);
    }
}
