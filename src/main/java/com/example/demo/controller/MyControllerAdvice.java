package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = MyException.class)
    public Map errorHandler(MyException ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMsg());
        return map;
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map errorHandler(NoSuchElementException ex) {
        Map map = new HashMap();
        map.put("code", 404);
        map.put("msg", ex.getMessage());
        return map;
    }

    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        return map;
    }
}

