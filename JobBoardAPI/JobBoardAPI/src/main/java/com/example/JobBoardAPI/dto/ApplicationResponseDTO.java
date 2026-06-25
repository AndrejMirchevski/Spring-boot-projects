package com.example.JobBoardAPI.dto;

import com.example.JobBoardAPI.entity.ApplicationStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponseDTO {
    private Long id;
    private Long candidateId;
    private Long postingId;
    private ApplicationStatus status;
    private String coverLetter;
}
