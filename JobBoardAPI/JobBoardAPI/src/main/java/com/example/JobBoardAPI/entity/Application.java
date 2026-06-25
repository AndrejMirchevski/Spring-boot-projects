package com.example.JobBoardAPI.entity;

import com.example.JobBoardAPI.dto.ApplicationCreateRequest;
import com.example.JobBoardAPI.dto.CandidateCreateRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "posting_id")
    private JobPosting jobPosting;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(length = 2000)
    private String coverLetter;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
