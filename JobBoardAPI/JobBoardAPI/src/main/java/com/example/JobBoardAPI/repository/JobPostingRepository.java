package com.example.JobBoardAPI.repository;

import com.example.JobBoardAPI.entity.JobPosting;
import com.example.JobBoardAPI.entity.Seniority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepository extends JpaRepository<Long, JobPosting> {
    Page<JobPosting> findDeletedAtIsNull(Pageable pageable);

    Page<JobPosting> findByTitleContainingIgnoreCaseAndDeleteAtIsNull(String title, Pageable pageable);

    Page<JobPosting> findByLocationContainingIgnoreCaseAndDeletedAtIsNull(String location, Pageable pageable);

    Page<JobPosting> findBySeniorityAndDeletedAtIsNull(Seniority seniority, Pageable pageable);

    Page<JobPosting> findByTagsContainingAndDeletedAtIsNull(String tag, Pageable pageable);
}
