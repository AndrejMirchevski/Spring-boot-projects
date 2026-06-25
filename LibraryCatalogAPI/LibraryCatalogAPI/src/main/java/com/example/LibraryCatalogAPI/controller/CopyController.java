package com.example.LibraryCatalogAPI.controller;

// POST /books/{id}/copies
// PATHC /copies/{id}/status

import com.example.LibraryCatalogAPI.dto.CopyCreateRequestDTO;
import com.example.LibraryCatalogAPI.dto.CopyStatusUpdateDTO;
import com.example.LibraryCatalogAPI.entity.Copy;
import com.example.LibraryCatalogAPI.entity.CopyStatus;
import com.example.LibraryCatalogAPI.service.CopyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CopyController {
    private final CopyService copyService;

    @PostMapping("/books/{bookId}/copies")
    public Copy createCopy(@PathVariable Long bookId, @RequestBody @Valid CopyCreateRequestDTO dto){
        return copyService.addACopy(bookId, dto);
    }

    @PatchMapping("/books/{bookId}/status")
    public Copy updateStatus(@PathVariable Long copyId, @RequestBody @Valid CopyStatusUpdateDTO dto){
        return copyService.updateStatus(copyId, dto);
    }
}
