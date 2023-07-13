package br.com.vitorbarberino.desafiotodolist.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vitorbarberino.desafiotodolist.exception.RestNotValidException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<RestNotValidException>> MethodArgumentNotValidExceptionHandler(ConstraintViolationException e) {
        List<RestNotValidException> errors = new ArrayList<>();
        e.getConstraintViolations().forEach(err -> {
            errors.add(new RestNotValidException(err.getPropertyPath().toString(), err.getMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    };

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<RestNotValidException>> MethodArgumentNotValidExceptionhandler(MethodArgumentNotValidException e) {
        List<RestNotValidException> errors = new ArrayList<>();

        e.getAllErrors().forEach(err -> {
            errors.add(new RestNotValidException("validation error", e.getMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestNotValidException> RuntimeExceptionHandler(RuntimeException e) {
        return ResponseEntity.badRequest().body(new RestNotValidException("id inválido.", e.getMessage()));
    }
}
