package com.example.JobBoardAPI.repository;

import com.example.JobBoardAPI.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByDeletedAtIsNull(Long id);

    Optional<Candidate> findByEmailAndDeletedAtIsNull(String email);

    Page<Candidate> findDeletedAtIsNull(Pageable pageable);

    Candidate findByIdAndDeletedIsNull(Long id);
}
