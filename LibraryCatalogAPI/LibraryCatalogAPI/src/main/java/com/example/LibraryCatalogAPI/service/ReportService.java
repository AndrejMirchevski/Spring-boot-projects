package com.example.LibraryCatalogAPI.service;

import com.example.LibraryCatalogAPI.dto.CategoryReportDTO;
import com.example.LibraryCatalogAPI.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final BookRepository bookRepository;

    public List<CategoryReportDTO> getCategoryReport(){

    List<CategoryReportDTO> report =
            bookRepository.getBooksByCategoryReport();

        if(report.isEmpty()){
        throw new RuntimeException(
                "No report data available"
        );
    }

        return report;
}
}
