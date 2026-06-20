package com.example.Real_Estate_Listings_API.dto;

import com.example.Real_Estate_Listings_API.entity.ListingStatus;
import jakarta.validation.constraints.NotNull;

public class StatusUpdateRequest {
    @NotNull(message = "Targer status must not be empty")
    private ListingStatus status;

    public ListingStatus getStatus(){ return status; }
    public void setStatus(ListingStatus status){
        this.status = status;
    }
}
