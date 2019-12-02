package com.exception;

public class TicketException extends AppException {
    public TicketException(String message) {
        super("Create ticket Error" + message);
    }
}
