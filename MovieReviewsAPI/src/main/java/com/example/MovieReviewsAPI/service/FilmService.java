package com.example.MovieReviewsAPI.service;

import com.example.MovieReviewsAPI.entity.AuditLog;
import com.example.MovieReviewsAPI.entity.Film;
import com.example.MovieReviewsAPI.entity.Review;
import com.example.MovieReviewsAPI.exception.NotFoundException;
import com.example.MovieReviewsAPI.repository.AuditLogRepository;
import com.example.MovieReviewsAPI.repository.FilmRepository;
import com.example.MovieReviewsAPI.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final AuditLogRepository auditLogRepository;
    private final ReviewRepository reviewRepository;

    public Film createFilm(Film film){
        boolean exists = filmRepository.existsByTitleAndYear(film.getTitle(), film.getYear());

        if(exists){
            throw new RuntimeException("film already exists");
        }

        film.setDeleted(false);
        Film saved = filmRepository.save(film);

        auditLogRepository.save(
                createAudit("CREATE", "Film", saved.getId())
        );

        return saved;
    }

    public Film findFIlmById(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new NotFoundException("can not find film by that id"));

        if(film.isDeleted()){
            throw new NotFoundException("film is deleted");
        }

        return film;
    }

    public Page<Film> getAllFilms(Pageable pageable){
        return filmRepository.findByDeletedFalse(pageable);
    }

    public List<Film> findByTitleGenreYearRange(String title, String genre, Integer yearFrom, Integer yearTo){
        List<Film> films = filmRepository.findByDeletedFalse();

        return films.stream()
                .filter(film ->
                        title == null ||
                                film.getTitle().toLowerCase()
                                        .contains(title.toLowerCase())
                ).filter(film ->
                        genre == null ||
                        film.getGenre().toLowerCase().contains(genre.toLowerCase())
                ).filter(film ->
                        yearFrom == null ||
                        film.getYear() >= yearFrom
                ).filter(film ->
                        yearTo == null ||
                        film.getYear() <= yearTo).toList();
    }

    public void deleteFilm(Long id){
        Film film = findFIlmById(id);

        film.setDeleted(true);
        filmRepository.save(film);

        auditLogRepository.save(
                createAudit("DELETE", "film", id)
        );
    }

    public List<Review> getFilmReviews(Long id)




    private AuditLog createAudit(String action, String entityType, Long entityId){
        AuditLog auditLog = new AuditLog();

        auditLog.setAction(action);
        auditLog.setEntityId(entityId);
        auditLog.setEntityType(entityType);
        auditLog.setTimeStamp(LocalDateTime.now());

        return auditLog;
    }


}
