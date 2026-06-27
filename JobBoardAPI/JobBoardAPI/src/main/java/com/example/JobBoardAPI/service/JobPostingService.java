package com.example.JobBoardAPI.service;

import com.example.JobBoardAPI.dto.PostingCreateRequest;
import com.example.JobBoardAPI.entity.JobPosting;
import com.example.JobBoardAPI.repository.JobPostingRepository;
import org.springframework.stereotype.Service;

@Service
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;

    public JobPostingService(JobPostingRepository jobPostingRepository){
        this.jobPostingRepository = jobPostingRepository;
    }

    public JobPosting createJobPosting(PostingCreateRequest request){
        JobPosting jobPosting = new JobPosting();

        jobPosting.setTitle(request.getTitle());
        jobPosting.set
    }
}
