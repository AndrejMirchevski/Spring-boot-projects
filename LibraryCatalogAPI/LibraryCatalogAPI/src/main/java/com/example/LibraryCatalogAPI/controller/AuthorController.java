package com.example.LibraryCatalogAPI.controller;

import com.example.LibraryCatalogAPI.dto.AuthorCreateRequest;
import com.example.LibraryCatalogAPI.dto.AuthorResponseDTO;
import com.example.LibraryCatalogAPI.entity.Author;
import com.example.LibraryCatalogAPI.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public AuthorResponseDTO create(@RequestBody @Valid AuthorResponseDTO dto){
        return authorService.createAuthor(dto);
    }
}
