package com.mh.api.MhAPI.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e, WebRequest request){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        log.debug(e.getMessage());
        return createResponseEntity(pd,null, HttpStatus.NOT_FOUND, request);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGeneralException(Exception e, WebRequest request){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        log.debug(e.getMessage());
        return createResponseEntity(pd,null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
