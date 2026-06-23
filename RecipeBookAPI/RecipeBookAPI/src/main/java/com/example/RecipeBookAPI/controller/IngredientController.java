package com.example.RecipeBookAPI.controller;

import com.example.RecipeBookAPI.dto.IngredientDTO;
import com.example.RecipeBookAPI.entity.Ingredient;
import com.example.RecipeBookAPI.service.IngredientService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes/{recipeId}/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    //Add an ingredient
    @PostMapping
    public Ingredient addIngredient(@PathVariable Long recipeId, @Valid @RequestBody IngredientDTO dto){
        return ingredientService.addIngredient(recipeId,dto);
    }

    //delete an ingredient
    @DeleteMapping
    public void deleteIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId){
        ingredientService.deleteIngredient(recipeId, ingredientId);
    }
}
