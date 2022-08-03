package com.nsu.meet.nsu.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String cause) {
        super(cause);
    }
}
