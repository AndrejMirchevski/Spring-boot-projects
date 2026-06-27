package com.example.MovieReviewsAPI.repository;

import com.example.MovieReviewsAPI.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    boolean existsByTitleAndYear(String title, Integer year);

    List<Film> findByTitleContainingIgnoreCase(String title);

    List<Film> findByGenreIgnoreCase(String genre);

    List<Film> findByYearBetween(Integer start, Integer end);

    List<Film> findByDeletedFalse();

    Page<Film> findByDeletedFalse(Pageable pageable);
}
