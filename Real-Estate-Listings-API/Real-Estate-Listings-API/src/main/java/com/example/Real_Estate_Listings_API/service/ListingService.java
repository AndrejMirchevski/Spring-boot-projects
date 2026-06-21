package com.example.Real_Estate_Listings_API.service;

import com.example.Real_Estate_Listings_API.dto.InquiryRequest;
import com.example.Real_Estate_Listings_API.dto.ListingCreateRequest;
import com.example.Real_Estate_Listings_API.dto.ListingResponce;
import com.example.Real_Estate_Listings_API.dto.StatusUpdateRequest;
import com.example.Real_Estate_Listings_API.entity.Inquiry;
import com.example.Real_Estate_Listings_API.entity.Listing;
import com.example.Real_Estate_Listings_API.entity.ListingStatus;
import com.example.Real_Estate_Listings_API.exception.BuisnessInvariantException;
import com.example.Real_Estate_Listings_API.exception.RecourseNotFoundException;
import com.example.Real_Estate_Listings_API.repository.InquiryRepository;
import com.example.Real_Estate_Listings_API.repository.ListingRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ListingService {
    private final ListingRepository listingRepository;
    private final InquiryRepository inquiryRepository;

    public ListingService(ListingRepository listingRepository, InquiryRepository inquiryRepository){
        this.inquiryRepository = inquiryRepository;
        this.listingRepository = listingRepository;
    }

    public ListingResponce CreateListing(ListingCreateRequest listingCreateRequest){
        Listing listing = new Listing();
        mapRequestToEntity(listingCreateRequest, listing);
        listing.setStatus(ListingStatus.ACTIVE);

        Listing saved = listingRepository.save(listing);
        return mapToResponce(saved);
    }

    public ListingResponce GetListById(Long id){
        Listing listing = listingRepository.findById(id).orElseThrow(
                () -> new RecourseNotFoundException("Can not find listing with id: " + id)
        );
        return mapToResponce(listing);
    }

    public Page<ListingResponce> getListings(String city, Double minPrice, Double maxPrice, String type, Pageable pageable){
        return listingRepository.findWithFilters(city,minPrice,maxPrice,type,pageable).map(this::mapToResponce);
    }

    public ListingResponce updateListing(Long id, ListingCreateRequest request){
        Listing listing = listingRepository.findById(id).
                orElseThrow(() -> new RecourseNotFoundException("Can not find listing by id " + id));

        if(listing.getStatus() == ListingStatus.SOLD || listing.getStatus() == ListingStatus.RENTED){
            throw new BuisnessInvariantException("A listing with status " + listing.getStatus() + " can not be updated");
        }

        mapRequestToEntity(request, listing);
        Listing updated = listingRepository.save(listing);
        return mapToResponce(updated);
    }

    public ListingResponce updateStatus(Long id, StatusUpdateRequest request){
        Listing listing = listingRepository.findById(id).
                orElseThrow(() -> new RecourseNotFoundException("cannot find listing by id " + id));

        if(listing.getStatus() == ListingStatus.SOLD || listing.getStatus() == ListingStatus.RENTED){
            throw new BuisnessInvariantException("A listing with status " + listing.getStatus() + " can not be updated");
        }

        listing.setStatus(request.getStatus());
        Listing updated = listingRepository.save(listing);
        return mapToResponce(updated);
    }

    public void softDelete(Long id){
        Listing listing = listingRepository.findById(id).
                orElseThrow(() -> new RecourseNotFoundException("cannot find listing by id " + id));
        if(listing.getStatus() == ListingStatus.SOLD || listing.getStatus() == ListingStatus.RENTED){
            throw new BuisnessInvariantException("A listing with status " + listing.getStatus() + " can not be updated");
        }

        listing.setDeletedAt(LocalDateTime.now());
        listingRepository.save(listing);
    }


    public void recordInquiry(Long listingId, InquiryRequest request) {
        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RecourseNotFoundException("Listing not found with id: " + listingId));

        Inquiry inquiry = new Inquiry();
        inquiry.setListing(listing);
        inquiry.setClientName(request.getClientName());
        inquiry.setClientEmail(request.getClientEmail());
        inquiry.setClientPhoneNumber(request.getClientPhone());
        inquiry.setMessage(request.getMessage());

        inquiryRepository.save(inquiry);
    }




    ///////////////////////////

    public void mapRequestToEntity(ListingCreateRequest src, Listing dest){
        dest.setTitle(src.getTitle());
        dest.setType(src.getType());
        dest.setListingKind(src.getListingKind());
        dest.setPrice(src.getPrice());
        dest.setCurrency(src.getCurrency());
        dest.setCity(src.getCity());
        dest.setBedrooms(src.getBedrooms());
        dest.setBathrooms(src.getBathrooms());
        dest.setSqm(src.getSqm());
    }

    public ListingResponce mapToResponce(Listing entity){
        ListingResponce res = new ListingResponce();
        res.setId(entity.getId());
        res.setTitle(entity.getTitle());
        res.setType(entity.getType());
        res.setListingKind(entity.getListingKind());
        res.setPrice(entity.getPrice());
        res.setCurrency(entity.getCurrency());
        res.setCity(entity.getCity());
        res.setBedrooms(entity.getBedrooms());
        res.setBathrooms(entity.getBathrooms());
        res.setSqm(entity.getSqm());
        res.setStatus(entity.getStatus());
        res.setCreatedAt(entity.getCreatedAt());
        res.setUpdatedAt(null);

        return res;
    }
}
