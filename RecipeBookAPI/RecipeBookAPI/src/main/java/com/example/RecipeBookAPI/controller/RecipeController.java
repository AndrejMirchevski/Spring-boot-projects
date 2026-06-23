package com.example.RecipeBookAPI.controller;

import com.example.RecipeBookAPI.dto.RecipeCreateRequestDTO;
import com.example.RecipeBookAPI.entity.Recipe;
import com.example.RecipeBookAPI.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    //creating a recipe
    @PostMapping
    public Recipe createRecipe(@Valid @RequestBody RecipeCreateRequestDTO dto){
        return recipeService.createRecipe(dto);
    }

    //get one recipe
    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long recipeId){
        return recipeService.getRecipe(recipeId);
    }

    //get all recipes
    @GetMapping
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    //Update a recipe
    @PostMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody RecipeCreateRequestDTO dto){
        return recipeService.updateRecipe(id, dto);
    }

    //Delete Recipe
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }
}
