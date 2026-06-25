package com.example.JobBoardAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class PostingCreateRequest {
    @NotBlank
    private String title;

    @NotNull
    private Long companyId;

    @NotBlank
    private String location;

    @NotNull
    private String seniority;

    @NotBlank
    @Size(min = 10, max = 3000)
    private String description;

    private List<String > tags;
}
