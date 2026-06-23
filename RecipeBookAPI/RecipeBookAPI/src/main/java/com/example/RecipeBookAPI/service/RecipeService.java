package com.example.RecipeBookAPI.service;

import com.example.RecipeBookAPI.dto.RecipeCreateRequestDTO;
import com.example.RecipeBookAPI.entity.Ingredient;
import com.example.RecipeBookAPI.entity.Recipe;
import com.example.RecipeBookAPI.exception.ConflictException;
import com.example.RecipeBookAPI.exception.NotFoundException;
import com.example.RecipeBookAPI.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    //creating a recipe
    public Recipe createRecipe(RecipeCreateRequestDTO dto){

        if(dto.getIngredients() == null || dto.getIngredients().isEmpty()){
            throw new ConflictException("Recipe must have ingredients");
        }

        if(dto.getSteps() == null || dto.getSteps().isEmpty()){
            throw new ConflictException("Recipe must have steps");
        }

        Recipe recipe = new Recipe();
        recipe.setTitle(dto.getTitle());
        recipe.setCuisine(dto.getCuisine());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setServings(dto.getServings());
        recipe.setTags(dto.getTags());

        List<Ingredient> ingredientList = dto.getIngredients()
                .stream()
                .map(name -> {
                    Ingredient ing = new Ingredient();
                    ing.setName(name);
                    ing.setRecipe(recipe);
                    return ing;
                })
                .collect(Collectors.toList());

        recipe.setIngredients(ingredientList);

        return recipeRepository.save(recipe);
    }


    //getting a recipe by an id
    public Recipe getRecipe(Long recipeId){
        return recipeRepository.findById(recipeId).filter(r -> r.getDeletedAt() == null).orElseThrow(() ->
                new NotFoundException("Recipe not found by index " + recipeId));
    }

    //getting all recipes
    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll().stream().filter(r -> r.getDeletedAt() == null).toList();
    }

    //updating a recipe
    public Recipe updateRecipe(Long recipeId, RecipeCreateRequestDTO dto){
        Recipe recipe = recipeRepository.findById(recipeId).filter(r -> r.getDeletedAt() == null).orElseThrow(() ->
                new NotFoundException("recipe missing or is deleted"));

        recipe.setTitle(dto.getTitle());
        recipe.setCuisine(dto.getCuisine());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setServings(dto.getServings());
        recipe.setTags(dto.getTags());

        return recipeRepository.save(recipe);
    }

    //soft delete a recipe
    public void deleteRecipe(Long recipeId){
        Recipe recipe = recipeRepository.findById(recipeId).filter(r -> r.getDeletedAt() == null).orElseThrow(() ->
                new NotFoundException("recipe missing or already deleted"));

        recipe.setDeletedAt(LocalDateTime.now());
        recipeRepository.save(recipe);
    }
}
