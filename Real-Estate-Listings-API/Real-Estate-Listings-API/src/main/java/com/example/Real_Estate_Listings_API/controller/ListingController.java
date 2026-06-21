package com.example.Real_Estate_Listings_API.controller;

import com.example.Real_Estate_Listings_API.dto.ListingCreateRequest;
import com.example.Real_Estate_Listings_API.dto.ListingResponce;
import com.example.Real_Estate_Listings_API.dto.StatusUpdateRequest;
import com.example.Real_Estate_Listings_API.service.ListingService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ListingController {

    private final ListingService listingService;

    public ListingController(ListingService listingService){
        this.listingService = listingService;
    }

    @PostMapping("/listings")
    public ResponseEntity<ListingResponce> CreateListing(@Valid @RequestBody ListingCreateRequest request){
        return new ResponseEntity<>(listingService.CreateListing(request), HttpStatus.CREATED);
    }

    @GetMapping("/listings/{id}")
    public ResponseEntity<ListingResponce> getListingById(@PathVariable Long id){
        return ResponseEntity.ok(listingService.GetListById(id));
    }

    @GetMapping("/listings")
    public ResponseEntity<Page<ListingResponce>> getListings(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String type,
            @PageableDefault(size = 20) Pageable pageable){
        return ResponseEntity.ok(listingService.getListings(city, minPrice, maxPrice, type, pageable));
    }

    // FIXED: Path changed to /listings/{id} and method calls service.updateListing
    @PutMapping("/listings/{id}")
    public ResponseEntity<ListingResponce> updateListing(
            @PathVariable Long id,
            @Valid @RequestBody ListingCreateRequest request){
        return ResponseEntity.ok(listingService.updateListing(id, request));
    }

    @PatchMapping("/listings/{id}/status")
    public ResponseEntity<ListingResponce> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody StatusUpdateRequest request) {
        return ResponseEntity.ok(listingService.updateStatus(id, request));
    }

    @DeleteMapping("/listings/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id){
        listingService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}