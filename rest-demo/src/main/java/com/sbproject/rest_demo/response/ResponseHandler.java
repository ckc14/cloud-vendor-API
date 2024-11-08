package com.sbproject.rest_demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.HashMap;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpstatus, Object responseObject){

        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpstatus);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpstatus);
    }
}
