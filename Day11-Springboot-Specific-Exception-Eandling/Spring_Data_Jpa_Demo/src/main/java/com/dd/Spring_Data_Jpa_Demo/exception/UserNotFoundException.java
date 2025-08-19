package com.dd.Spring_Data_Jpa_Demo.exception;

//Step 02 custom exception handler
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
