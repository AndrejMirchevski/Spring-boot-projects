package com.example.MovieReviewsAPI.repository;

import com.example.MovieReviewsAPI.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
