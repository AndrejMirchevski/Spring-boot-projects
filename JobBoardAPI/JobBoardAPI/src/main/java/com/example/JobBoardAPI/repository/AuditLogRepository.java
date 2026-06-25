package com.example.JobBoardAPI.repository;

import com.example.JobBoardAPI.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<Long, AuditLog> {
}
