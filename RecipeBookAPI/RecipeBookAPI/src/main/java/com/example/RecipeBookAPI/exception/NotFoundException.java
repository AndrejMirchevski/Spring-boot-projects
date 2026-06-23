package com.example.RecipeBookAPI.exception;
//404
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
