package com.hillel.lesson_12.validator.exceptions;

public class PhoneValidationException extends RuntimeException{
    public PhoneValidationException(String message) {
        super(message);
    }
}
