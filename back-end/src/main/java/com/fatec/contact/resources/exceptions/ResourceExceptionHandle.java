package com.fatec.contact.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandle {

     @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotfoundException(
        EntityNotFoundException e,
        HttpServletRequest request
    ){
        StandardError error = new StandardError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource Not Found");
        error.setMessage(e.getMessage());
        error.setTimeStamp(Instant.now());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErros> validationException(
        MethodArgumentNotValidException exception,
        HttpServletRequest request
    ){
        ValidationErros error = new ValidationErros();
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.addError("Resource Not Found");
        error.setMessage(exception.getMessage());
        error.setTimeStamp(Instant.now());
        error.setPath(request.getRequestURI());

        exception.getBindingResult()
                .getFieldErrors()
                .forEach( e -> error.addError(e.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

}
