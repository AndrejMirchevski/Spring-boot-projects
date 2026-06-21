package com.example.Real_Estate_Listings_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class RealEstateListingsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateListingsApiApplication.class, args);
	}

}
