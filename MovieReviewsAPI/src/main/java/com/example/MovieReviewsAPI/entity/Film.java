package com.example.MovieReviewsAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int year;
    private String genre;

    @OneToMany(mappedBy = "film")
    private Review review;

    private boolean deleted = false;
}
