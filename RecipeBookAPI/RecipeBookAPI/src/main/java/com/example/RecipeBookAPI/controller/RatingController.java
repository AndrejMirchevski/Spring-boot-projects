package com.example.RecipeBookAPI.controller;
import com.example.RecipeBookAPI.dto.RatingDto;
import com.example.RecipeBookAPI.entity.Rating;
import com.example.RecipeBookAPI.service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes/{recipeId}/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    //Post a rating

    @PostMapping
    public Rating postRating(@PathVariable Long recipeId, @Valid @RequestBody RatingDto dto){
        return ratingService.rateRecipe(recipeId, dto);
    }
}
