package com.example.ordermanagement.exception;

public class OrderException extends RuntimeException {

    public OrderException(String message) {
        super("Order Exception Occurred : "+message);
    }
}
