package com.sbproject.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler (value = {CloudVendorNotFoundException.class})                   // If you want more exceptions to be handled then write after giving comma
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendorNotFoundException)
    {
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }

}
