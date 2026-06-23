package com.example.LibraryCatalogAPI.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthorCreateRequest {
    @NotNull
    private String name;

    @NotNull
    private String surName;
}
