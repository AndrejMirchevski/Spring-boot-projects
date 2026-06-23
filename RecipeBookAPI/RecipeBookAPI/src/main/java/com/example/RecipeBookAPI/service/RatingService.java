package com.example.RecipeBookAPI.service;

import com.example.RecipeBookAPI.dto.RatingDto;
import com.example.RecipeBookAPI.entity.Rating;
import com.example.RecipeBookAPI.entity.Recipe;
import com.example.RecipeBookAPI.exception.ConflictException;
import com.example.RecipeBookAPI.exception.NotFoundException;
import com.example.RecipeBookAPI.repository.RatingRepository;
import com.example.RecipeBookAPI.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RecipeRepository recipeRepository;

    public Rating rateRecipe(Long recipeId, RatingDto dto){
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() ->
                new NotFoundException("missing recipe by id " + recipeId));

        //is it 1 to 5 validation
        if(dto.getStars() < 0 || dto.getStars() > 5){
            throw new ConflictException("you can rate only 1 to 5");
        }

        Rating rating = new Rating();
        rating.setStars(dto.getStars());
        rating.setRecipe(recipe);

        return ratingRepository.save(rating);
    }

}
