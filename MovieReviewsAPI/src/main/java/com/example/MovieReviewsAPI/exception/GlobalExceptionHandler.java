package com.example.MovieReviewsAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GlobalExceptionHandler {

    //404 not found
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(NotFoundException ex){

        Map<String, Object> response = new HashMap<>();
        response.put("timeStamp", LocalDateTime.now());
        response.put("status", 404);
        response.put("error", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // 409 duplicate
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<?> handleConflict(DuplicateResourceException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("Status", 404);
        response.put("error", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex){
        Map<String, Object> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // 500 generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex){
        Map<String, Object> response = new HashMap<>();
        response.put("Timestamp", LocalDateTime.now());
        response.put("Status", 500);
        response.put("error", "internal server error");

        return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
