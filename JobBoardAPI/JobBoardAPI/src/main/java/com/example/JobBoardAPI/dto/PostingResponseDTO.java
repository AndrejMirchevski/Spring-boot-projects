package com.example.JobBoardAPI.dto;

import com.example.JobBoardAPI.entity.Seniority;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostingResponseDTO {
    private Long id;
    private String title;
    private Long companyId;
    private String location;
    private Seniority seniority;
    private String description;
    private boolean closed;
    private List<String> tags;
}
