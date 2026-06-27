package com.example.MovieReviewsAPI.dto;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmResponse {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private Double averageRating;
}
