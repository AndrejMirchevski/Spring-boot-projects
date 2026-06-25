package com.example.JobBoardAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApplicationCreateRequest {
    @NotNull
    private Long candidateId;

    @NotBlank
    @Size(max = 2000)
    private String coverLetter;
}
