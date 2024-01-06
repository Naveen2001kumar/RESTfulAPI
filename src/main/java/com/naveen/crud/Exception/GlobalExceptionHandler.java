package com.naveen.crud.Exception;

import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Error> handleStudentNotFoundException(StudentNotFoundException ex)
    {
     Error error = new Error();
     error.setStatusCode(HttpStatus.NOT_FOUND.value());
     error.setMessage(ex.getMessage());
     error.setTimestap(new Date());
     return new ResponseEntity<Error>(error , HttpStatus.NOT_FOUND);
    }
}
