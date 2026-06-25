package com.example.JobBoardAPI.repository;

import com.example.JobBoardAPI.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Long, Application> {
    Page<Application> findByCandidateIdAndDeletedAtIsNull(Long id, Pageable pageable);

    boolean existsByCandidateIdAndPostingIdAndStatusInAndDeletedAtIsNull(
            Long candidateId,
            Long postingId,
            Pageable pageable
    );

    Page<Application> findByDeletedAtIsNull(Pageable pageable);
}
