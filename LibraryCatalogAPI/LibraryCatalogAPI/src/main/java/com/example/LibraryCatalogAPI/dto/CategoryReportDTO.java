package com.example.LibraryCatalogAPI.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryReportDTO {
    private String categoryName;
    private Long totalBooks, totalCopies;
}
