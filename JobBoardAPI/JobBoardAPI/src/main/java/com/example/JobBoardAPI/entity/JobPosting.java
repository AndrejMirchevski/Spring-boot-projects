package com.example.JobBoardAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long companyId;

    private String location;

    @Enumerated(EnumType.STRING)
    private Seniority seniority;

    @Column(length = 3000)
    private String description;

    private boolean closed;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "posting")
    private List<Application> applications = new ArrayList<>();
}
