package com.example.RecipeBookAPI.service;

import com.example.RecipeBookAPI.dto.IngredientDTO;
import com.example.RecipeBookAPI.entity.Ingredient;
import com.example.RecipeBookAPI.entity.Recipe;
import com.example.RecipeBookAPI.exception.ConflictException;
import com.example.RecipeBookAPI.exception.NotFoundException;
import com.example.RecipeBookAPI.repository.IngredientRepository;
import com.example.RecipeBookAPI.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    //adding an ingredient to a recipe
    public Ingredient addIngredient(Long recipeId, IngredientDTO dto){
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() ->
                new NotFoundException("Recipe Not found at index " + recipeId));

        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setQuantity(dto.getQuantity());
        ingredient.setUnit(dto.getUnit());
        ingredient.setRecipe(recipe);

        return ingredientRepository.save(ingredient);
    }

    //Delete an ingredient by its id and recipe id
    public void deleteIngredient(Long recipeId, Long ingredientId){
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() ->
                new NotFoundException("Recipe Not found by index " + recipeId));

        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() ->
                new NotFoundException("Ingredient not found at index " + ingredientId));

        // make sure ingredient is added to the correct recipe
        if(!ingredient.getRecipe().getId().equals(recipe.getId())){
            throw new ConflictException("Ingredient does not belong to this recipe");
        }

        //make deleting last ingredient not available
        List<Ingredient> ingredients = recipe.getIngredients();

        if(ingredients.size() <= 1){
            throw new ConflictException("Recipe must have at least one ingreient");
        }
        ingredientRepository.delete(ingredient);
    }
}
