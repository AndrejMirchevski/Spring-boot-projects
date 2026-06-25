package com.example.JobBoardAPI.dto;

import com.example.JobBoardAPI.entity.ApplicationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApplicationStatusRequest {
    @NotNull
    private ApplicationStatus status;
}
