package com.example.LibraryCatalogAPI.service;

import com.example.LibraryCatalogAPI.dto.CopyCreateRequestDTO;
import com.example.LibraryCatalogAPI.dto.CopyStatusUpdateDTO;
import com.example.LibraryCatalogAPI.entity.Book;
import com.example.LibraryCatalogAPI.entity.Copy;
import com.example.LibraryCatalogAPI.entity.CopyStatus;
import com.example.LibraryCatalogAPI.exception.BadRequestException;
import com.example.LibraryCatalogAPI.exception.NotFoundException;
import com.example.LibraryCatalogAPI.repository.BookRepository;
import com.example.LibraryCatalogAPI.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;

    //register new Copy
    public Copy addACopy(Long bookId, CopyCreateRequestDTO dto){
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new NotFoundException("book by that id does not exist"));

        Copy copy = new Copy();
        copy.setBook(book);

        if(dto.getStatus() == null){
            copy.setCopyStatus(CopyStatus.AVAILABLE);
        }else {
            copy.setCopyStatus(CopyStatus.valueOf(dto.getStatus().toUpperCase()));
        }

        return copyRepository.save(copy);
    }

    //update copy
    public Copy updateStatus(Long copyId, CopyStatusUpdateDTO dto){
        Copy copy = copyRepository.findById(copyId).orElseThrow(() ->
                new NotFoundException("Copy by that id does not exist"));

        try{
            copy.setCopyStatus(
                    CopyStatus.valueOf(
                            dto.getStatus().toUpperCase()
                    )
            );
        } catch (IllegalArgumentException e){
            throw new BadRequestException(
                    "Allowed values: AVAILABLE, LOST, DAMAGED"
            );
        }

        return copyRepository.save(copy);
    }
}
