package com.example.LibraryCatalogAPI.repository;

import com.example.LibraryCatalogAPI.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public interface BookRepository extends JpaRepository<Book, Long>{

    //make sure ISBN is unique
    boolean existsByIsbn(String isbn);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthor_NameContainingIgnoreCases(String authorName);

    List<Book> findByCategory_NameIgnoreCase(String categoryName);

    List<Book> findByPublishedYearBetween(Integer from, Integer to);
}
