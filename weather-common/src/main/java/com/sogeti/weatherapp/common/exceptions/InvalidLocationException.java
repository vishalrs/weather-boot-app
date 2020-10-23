package com.sogeti.weatherapp.common.exceptions;


public class InvalidLocationException extends RuntimeException{
    public InvalidLocationException(String message) {
        super(message);
    }

    public InvalidLocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
