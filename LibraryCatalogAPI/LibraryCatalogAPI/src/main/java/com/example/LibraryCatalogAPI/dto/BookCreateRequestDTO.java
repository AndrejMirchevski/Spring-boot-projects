package com.example.LibraryCatalogAPI.dto;
// for POST /book

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookCreateRequestDTO {
    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @NotNull
    private Long authorId;

    @NotNull
    private Long categoryId;

    @NotNull
    private Integer publishedYear;

    @NotBlank
    private String language;
}
