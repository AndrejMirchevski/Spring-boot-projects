package com.example.JobBoardAPI.service;

import com.example.JobBoardAPI.entity.AuditLog;
import com.example.JobBoardAPI.repository.AuditLogRepository;
import com.example.JobBoardAPI.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditLogRepository auditLogRepository;

}
