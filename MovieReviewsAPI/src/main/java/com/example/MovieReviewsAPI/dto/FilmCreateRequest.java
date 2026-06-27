package com.example.MovieReviewsAPI.dto;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmCreateRequest {
    private String title;
    private Integer year;
    private String genre;
}
