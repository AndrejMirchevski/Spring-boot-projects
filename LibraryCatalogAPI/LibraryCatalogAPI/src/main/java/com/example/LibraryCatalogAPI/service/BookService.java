package com.example.LibraryCatalogAPI.service;

import com.example.LibraryCatalogAPI.dto.BookCreateRequestDTO;
import com.example.LibraryCatalogAPI.dto.BookResponseDTO;
import com.example.LibraryCatalogAPI.exception.ConflictException;
import com.example.LibraryCatalogAPI.repository.AuthorRepository;
import com.example.LibraryCatalogAPI.repository.BookRepository;
import com.example.LibraryCatalogAPI.repository.CopyRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //private final BookRepository bookRepository;
    //private final AuthorRepository authorRepository;
    //private final CopyRepository copyRepository;

    //creating a book
    //public BookResponseDTO createBook(BookCreateRequestDTO dto){
        //if(bookRepository.existsByIsbn(dto.getIsbn())){
            //throw new ConflictException("ISBN is alredy taken");
     //   };
    //}
}
