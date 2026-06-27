package com.example.MovieReviewsAPI.repository;

import com.example.MovieReviewsAPI.entity.Film;
import com.example.MovieReviewsAPI.entity.Review;
import com.example.MovieReviewsAPI.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(User user);

    List<Review> findByFilm(Film film);

    boolean existsByUserAndFilm(User user, Film film);

    @Query("""
            SELECT AVG(r.rating)
            FROM Review r
            WHERE r.film.id = :filmId
            """)
    Double getAverageRating(Long filmId);

    @Query("""
            SELECT r.film
            FROM Review r
            WHERE f.deleted = false
            GROUP BY r.film
            HAVING COUNT(r) >= 10
            ORDER BY AVG(r.rating) DESC
            """)
    List<Film> getTopFilms(Pageable pageable);
}
