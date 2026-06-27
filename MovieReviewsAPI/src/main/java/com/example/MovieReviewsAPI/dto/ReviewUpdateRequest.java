package com.example.MovieReviewsAPI.dto;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewUpdateRequest {
    private Integer rating;
    private String body;
    private String title;
}
