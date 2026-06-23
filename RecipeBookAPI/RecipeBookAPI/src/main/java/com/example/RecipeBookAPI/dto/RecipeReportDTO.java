package com.example.RecipeBookAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeReportDTO {

    private Long id;
    private String title;
    private Double averageRating;
    private Long ratingCount;

}
