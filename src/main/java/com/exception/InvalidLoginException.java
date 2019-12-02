package com.exception;

public class InvalidLoginException extends AppException {
    public InvalidLoginException(String message) {
        super("Login Error!" + message);
    }
}
