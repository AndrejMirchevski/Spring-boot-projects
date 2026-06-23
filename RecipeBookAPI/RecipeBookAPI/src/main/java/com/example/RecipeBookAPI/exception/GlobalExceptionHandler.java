package com.example.RecipeBookAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GlobalExceptionHandler {

    //409
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> handleConflict(ConflictException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("status", 409);
        response.put("Error", "Conflict");
        response.put("message", ex.getMessage());
        response.put("timeStamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    //404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(NotFoundException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("Status", 404);
        response.put("Error", "Not Found");
        response.put("message", ex.getMessage());
        response.put("timeStamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //400 validation
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(Exception ex){
        Map<String, Object> response = new HashMap<>();
        response.put("Status", 400);
        response.put("error", "Bad Request");
        response.put("message", "Validation failed");
        response.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //500 fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex){
        Map<String, Object> response = new HashMap<>();

        response.put("Status", 500);
        response.put("error", "Internal server error");
        response.put("message", ex.getMessage());
        response.put("Timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
