package com.example.LibraryCatalogAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// do update book request   PUT /books/id

@Data
@Getter
@Setter
public class BookUpdateRequestDTO {

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
