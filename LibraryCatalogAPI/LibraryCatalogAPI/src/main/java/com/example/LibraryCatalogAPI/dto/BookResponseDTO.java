package com.example.LibraryCatalogAPI.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookResponseDTO {
    private Long id;
    private String isbn, title, authorName, categoryName, language;
    private Integer publishedYear, availableCopies, totalCopies;
}
