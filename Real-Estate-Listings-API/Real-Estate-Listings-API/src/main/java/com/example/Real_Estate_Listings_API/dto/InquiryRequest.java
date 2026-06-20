package com.example.Real_Estate_Listings_API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class InquiryRequest {
    @NotBlank(message = "Client name can not be empty")
    @Size(min = 2, max = 100, message = "name has to be between 2 and 100 characters long")
    private String ClientName;

    @NotBlank(message = "Message field can not be empty")
    @Email(message = "invalid email format")
    private String ClientEmail;

    @NotBlank(message = "Phone can not be empty")
    @Pattern(regexp = "^\\+?[0-9\\s-]{7,15}$", message = "Invalid phone number format")
    private String ClientPhone;

    @NotBlank(message = "message can not be empty")
    @Size(max = 500, message = "Messages are limited to 500 characters")
    private String message;

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    public String getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(String clientPhone) {
        ClientPhone = clientPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
