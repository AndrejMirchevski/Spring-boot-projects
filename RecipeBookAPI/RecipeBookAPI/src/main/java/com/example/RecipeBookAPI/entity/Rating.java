package com.example.RecipeBookAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(5)
    @Min(1)
    private Integer stars;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
