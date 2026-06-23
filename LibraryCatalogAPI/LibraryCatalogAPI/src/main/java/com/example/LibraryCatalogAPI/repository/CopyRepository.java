package com.example.LibraryCatalogAPI.repository;

import com.example.LibraryCatalogAPI.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
    List<Copy> findByBook_Id(Long bookId);
    Long countByBook_Id(Long bookId);
    Long countByBook_IdAndStatus(Long bookId, String staus);
}
