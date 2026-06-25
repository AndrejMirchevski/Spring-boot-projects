package com.example.LibraryCatalogAPI.service;

import com.example.LibraryCatalogAPI.dto.AuthorResponseDTO;
import com.example.LibraryCatalogAPI.entity.Author;
import com.example.LibraryCatalogAPI.exception.NotFoundException;
import com.example.LibraryCatalogAPI.repository.AuthorRepository;
import com.example.LibraryCatalogAPI.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    // posting authors

    public AuthorResponseDTO createAuthor(AuthorResponseDTO dto){
        Author author = new Author();
        author.setName(dto.getFullName());

        Author saved = authorRepository.save(author);

        return mapToResponse(saved);
    }

    //get author by id
    private AuthorResponseDTO getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("missing author by that id"));

        return mapToResponse(author);
    }

    //mapper
    public AuthorResponseDTO mapToResponse(Author author){
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setId(author.getId());
        dto.setFullName(author.getName());

        dto.setBookCount(author.getBooks() == null ? 0 : author.getBooks().size());

        return dto;
    }
}
