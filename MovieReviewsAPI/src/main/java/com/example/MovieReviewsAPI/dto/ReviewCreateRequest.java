package com.example.MovieReviewsAPI.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ReviewCreateRequest {
    private Long userId;
    private Integer rating;
    private String title;
    private String body;
}
