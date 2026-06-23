package com.example.RecipeBookAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {
    @NotBlank(message = "name can not be left blank")
    private String name;

    @NotNull(message = " quantity can not be left empty")
    private Double quantity;

    @NotBlank(message = "Unit can not be left empty")
    private String unit;
}
