package com.example.JobBoardAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateResponseDTO {
    private Long id;
    private String fullName;
    private String email;
}
