package com.example.LibraryCatalogAPI.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthorResponseDTO {
    private Long id;
    private String fullName;
    private Integer bookCount;
}
