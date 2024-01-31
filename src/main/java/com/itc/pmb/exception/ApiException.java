package com.itc.pmb.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
