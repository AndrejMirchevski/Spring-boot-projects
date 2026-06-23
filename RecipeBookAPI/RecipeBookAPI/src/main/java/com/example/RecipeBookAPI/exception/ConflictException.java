package com.example.RecipeBookAPI.exception;
//409
public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
