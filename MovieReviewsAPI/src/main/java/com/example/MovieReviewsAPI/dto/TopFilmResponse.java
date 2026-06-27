package com.example.MovieReviewsAPI.dto;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TopFilmResponse {
    private Long filmId;
    private String title;
    private Double averageRating;
    private Long reviewCount;
}
