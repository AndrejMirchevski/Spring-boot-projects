package com.example.Real_Estate_Listings_API.dto;

import jakarta.validation.constraints.*;

public class ListingCreateRequest {

    @NotBlank
    @Size(min = 10, max = 100, message = "Tittle must be between 10 and 100 characters long")
    private String title;

    @NotBlank(message = "type required")
    private String type;

    @NotBlank()
    private String listingKind;

    @NotNull
    @Positive
    private double price;

    @NotBlank
    private String currency;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotNull(message = "Number of bedrooms is required")
    @Min(value = 0, message = "Bedrooms cannot be negative")
    private Integer bedrooms;

    @NotNull(message = "Number of bathrooms is required")
    @Min(value = 0, message = "Bathrooms cannot be negative")
    private Integer bathrooms;

    @NotNull(message = "Square meters (sqm) cannot be null")
    @Min(value = 10, message = "Properties must be at least 10 sqm")
    private Integer sqm;

    public ListingCreateRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getListingKind() {
        return listingKind;
    }

    public void setListingKind(String listingKind) {
        this.listingKind = listingKind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getSqm() {
        return sqm;
    }

    public void setSqm(Integer sqm) {
        this.sqm = sqm;
    }
}
