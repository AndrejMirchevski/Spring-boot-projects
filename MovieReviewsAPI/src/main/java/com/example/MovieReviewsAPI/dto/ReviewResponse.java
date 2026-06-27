package com.example.MovieReviewsAPI.dto;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private Long userId;
    private Long filmId;
    private Integer rating;
    private String title;
    private String body;
    private Integer helpfulCount;
}
