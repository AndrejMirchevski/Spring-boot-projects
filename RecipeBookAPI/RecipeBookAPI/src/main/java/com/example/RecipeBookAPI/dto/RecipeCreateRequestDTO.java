package com.example.RecipeBookAPI.dto;

import com.example.RecipeBookAPI.entity.Cuisine;
import com.example.RecipeBookAPI.entity.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeCreateRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, message = "Title must be under 100 characters")
    private String title;

    @NotNull
    private Cuisine cuisine;

    @NotNull
    private Difficulty difficulty;

    @NotNull
    private Integer servings;

    @NotEmpty(message = "Recipe must have at least one ingredient")
    private List<String> ingredients;

    @NotEmpty(message = "Recipe must have at least one step")
    private List<String> steps;

    private List<String> tags;
}