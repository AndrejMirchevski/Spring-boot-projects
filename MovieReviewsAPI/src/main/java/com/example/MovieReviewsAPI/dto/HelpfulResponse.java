package com.example.MovieReviewsAPI.dto;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HelpfulResponse {
    private Long reviewId;
    private Integer helpfulCount;
}

