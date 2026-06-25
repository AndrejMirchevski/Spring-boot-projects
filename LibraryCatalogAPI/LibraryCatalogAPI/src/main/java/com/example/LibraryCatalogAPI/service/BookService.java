package com.example.LibraryCatalogAPI.service;

import com.example.LibraryCatalogAPI.dto.BookCreateRequestDTO;
import com.example.LibraryCatalogAPI.dto.BookResponseDTO;
import com.example.LibraryCatalogAPI.dto.BookUpdateRequestDTO;
import com.example.LibraryCatalogAPI.entity.Author;
import com.example.LibraryCatalogAPI.entity.Category;
import com.example.LibraryCatalogAPI.entity.Book;
import com.example.LibraryCatalogAPI.exception.ConflictException;
import com.example.LibraryCatalogAPI.exception.NotFoundException;
import com.example.LibraryCatalogAPI.repository.AuthorRepository;
import com.example.LibraryCatalogAPI.repository.BookRepository;
import com.example.LibraryCatalogAPI.repository.CategoryRepository;
import com.example.LibraryCatalogAPI.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    //creating a book
    public BookResponseDTO createBook(BookCreateRequestDTO dto){
        if(bookRepository.existsByIsbn(dto.getIsbn())){
            throw new ConflictException("ISBN is alredy taken");
        };

        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() ->
                new NotFoundException("Author missing"));

        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() ->
                new NotFoundException("Missing category"));

        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthor(author);
        book.setCategory(category);
        book.setPublishYear(dto.getPublishedYear());
        book.setLanguage(dto.getLanguage());

        Book saved = bookRepository.save(book);
        return mapToResponse(saved);
    }

    //GetBookById
    public BookResponseDTO getBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new NotFoundException("missing book by that id"));

        return mapToResponse(book);
    }

    //Search for books
    public List<BookResponseDTO> searchBooks(String title, String author, String category,
                                             Integer fromYear, Integer toYear) {

        List<Book> books = bookRepository.findAll();

        return books.stream()
                .filter(b -> title == null || b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(b -> author == null || b.getAuthor().getName().toLowerCase().contains(author.toLowerCase()))
                .filter(b -> category == null || b.getCategory().getName().equalsIgnoreCase(category))
                .filter(b -> fromYear == null || b.getPublishYear() >= fromYear)
                .filter(b -> toYear == null || b.getPublishYear() <= toYear)
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    //UpdateBook
    public BookResponseDTO updateBook(Long id, BookUpdateRequestDTO dto){
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Can not updage book by that id"));

        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() ->
                new NotFoundException("Can not find author by that id"));

        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() ->
                new NotFoundException("Can not find category by that id"));

        book.setTitle(dto.getTitle());
        book.setAuthor(author);
        book.setCategory(category);
        book.setPublishYear(dto.getPublishedYear());
        book.setLanguage(dto.getLanguage());

        return mapToResponse(bookRepository.save(book));
    }

    public BookResponseDTO mapToResponse(Book book){
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setCategoryName(book.getCategory().getName());
        dto.setPublishedYear(book.getPublishYear());
        dto.setLanguage(book.getLanguage());

        dto.setAvailableCopies(0);
        dto.setTotalCopies(0);

        return dto;
    }
}
