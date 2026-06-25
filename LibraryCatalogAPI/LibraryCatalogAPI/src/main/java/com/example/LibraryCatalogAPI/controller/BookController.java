package com.example.LibraryCatalogAPI.controller;

// POST  /books
// GET /books/{id}
// GET /books XXXXXXXXX
// PUT /books/{id}

import com.example.LibraryCatalogAPI.dto.BookCreateRequestDTO;
import com.example.LibraryCatalogAPI.dto.BookResponseDTO;
import com.example.LibraryCatalogAPI.dto.BookUpdateRequestDTO;
import com.example.LibraryCatalogAPI.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookResponseDTO create(@RequestBody @Valid BookCreateRequestDTO dto){
        return bookService.createBook(dto);
    }

    @GetMapping("/{id}")
    public BookResponseDTO getById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    //@GetMapping
    //public List<BookResponseDTO> search(@ModelAttribute BookSearch)

    @PutMapping("/{id}")
    public BookResponseDTO update(@PathVariable Long id, @RequestBody @Valid BookUpdateRequestDTO dto){
        return bookService.updateBook(id, dto);
    }
}
