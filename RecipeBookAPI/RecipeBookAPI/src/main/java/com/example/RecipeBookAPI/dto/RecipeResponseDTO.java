package com.example.RecipeBookAPI.dto;

import com.example.RecipeBookAPI.entity.Cuisine;
import com.example.RecipeBookAPI.entity.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeResponseDTO {
    private Long id;
    private String title;
    private Cuisine cuisine;
    private Difficulty difficulty;
    private Integer servings;
    private List<String> ingredients;
    private List< String > steps;
    private List< String > tags;
    private Double averageRating;
}
