package com.dd.Spring_Data_Jpa_Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //(SPECIFIC EXCEPTION)
    @ExceptionHandler
    public ResponseEntity<UserErrorResponce> handleException(UserNotFoundException exc){

        UserErrorResponce errorResponce = new UserErrorResponce();

        errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponce.setMessage(exc.getMessage());
        errorResponce.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponce,HttpStatus.NOT_FOUND);
    }

    //GENERIC EXCEPTION
    @ExceptionHandler
    public ResponseEntity<UserErrorResponce> genericException(Exception exc){//Catch all exception

        UserErrorResponce errorResponce = new UserErrorResponce();

        errorResponce.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponce.setMessage(exc.getMessage());
        errorResponce.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
    }
}
