package com.movieflix.config.exception;

public class UsernameAndPasswordInvalidException extends RuntimeException {
    public UsernameAndPasswordInvalidException(String message) {
        super(message);
    }
}
