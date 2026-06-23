package com.example.RecipeBookAPI.dto;

import com.example.RecipeBookAPI.entity.Cuisine;
import com.example.RecipeBookAPI.entity.Difficulty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeListDto {
    private Long id;
    private String title;
    private Cuisine cuisine;
    private Difficulty difficulty;
}
