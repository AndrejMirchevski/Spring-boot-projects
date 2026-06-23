package com.example.LibraryCatalogAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    private String title;
    private int publishYear;
    private String language;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies = new ArrayList<>();
}
