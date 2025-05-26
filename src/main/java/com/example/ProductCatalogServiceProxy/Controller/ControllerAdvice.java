package com.example.ProductCatalogServiceProxy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({Exception.class})
    private ResponseEntity<String> handleException(){
        return new ResponseEntity<String>("kuch toh gadbd hai", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
