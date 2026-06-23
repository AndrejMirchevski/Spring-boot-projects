package com.example.LibraryCatalogAPI.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CopyStatusUpdateDTO {
    @NotBlank
    private String status;
}
