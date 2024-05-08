package com.example.mobilt.app.ws.exceptions;


import java.io.Serial;

public class UserServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1536923009776068421L;
    public UserServiceException(String message) {
        super(message);
    }


}
