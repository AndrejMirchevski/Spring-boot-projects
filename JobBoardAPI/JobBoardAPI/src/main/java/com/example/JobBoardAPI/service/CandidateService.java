package com.example.JobBoardAPI.service;

import com.example.JobBoardAPI.dto.CandidateCreateRequest;
import com.example.JobBoardAPI.entity.Candidate;
import com.example.JobBoardAPI.repository.CandidateRepository;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    public Page<Candidate> getAllCandidates(Pageable pageable){
        return candidateRepository.findDeletedAtIsNull(pageable);
    }

    public Candidate getCandidateById(Long id){
        return candidateRepository.findByIdAndDeletedIsNull(id);
    }

    public Candidate createCandidate(CandidateCreateRequest dto){
        Candidate candidate = new Candidate();

        candidate.setFullName(dto.getFullName());
        candidate.setEmail(dto.getEmail());
        candidate.setCreatedAt(LocalDateTime.now());
        return candidateRepository.save(candidate);
    }
}
