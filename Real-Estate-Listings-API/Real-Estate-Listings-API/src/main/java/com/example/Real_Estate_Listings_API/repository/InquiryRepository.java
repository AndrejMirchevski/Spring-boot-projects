package com.example.Real_Estate_Listings_API.repository;

import com.example.Real_Estate_Listings_API.entity.Inquiry;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    Page<Inquiry> findByListingId(Long id, Pageable pageable);
}
