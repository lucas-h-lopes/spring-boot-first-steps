package com.study.springboot_project.controllers.exceptions;

import com.study.springboot_project.services.exceptions.DatabaseException;
import com.study.springboot_project.services.exceptions.RecordAlreadyExistsException;
import com.study.springboot_project.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionStandardBody> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        String message = e.getMessage();
        int status = HttpStatus.NOT_FOUND.value();
        String path = request.getRequestURI();
        ExceptionStandardBody err = new ExceptionStandardBody(Instant.now(), status, error, message, path);
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(RecordAlreadyExistsException.class)
    public ResponseEntity<ExceptionStandardBody> recordAlreadyExists(RecordAlreadyExistsException e, HttpServletRequest request) {
        String error = "Record already exists";
        String message = e.getMessage();
        int status = HttpStatus.NOT_FOUND.value();
        String path = request.getRequestURI();
        ExceptionStandardBody err = new ExceptionStandardBody(Instant.now(), status, error, message, path);
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionStandardBody> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Bad request";
        String message = e.getMessage();
        if (e.getFieldError() != null) {
             message = e.getFieldError().getDefaultMessage();
        }
        int status = HttpStatus.BAD_REQUEST.value();
        String path = request.getRequestURI();
        ExceptionStandardBody err = new ExceptionStandardBody(Instant.now(), status, error, message, path);
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ExceptionStandardBody> database(DatabaseException e, HttpServletRequest request) {
        String error = "Bad request";
        String message = e.getMessage();
        int status = HttpStatus.BAD_REQUEST.value();
        String path = request.getRequestURI();
        ExceptionStandardBody err = new ExceptionStandardBody(Instant.now(), status, error, message, path);
        return ResponseEntity.status(status).body(err);
    }
}
