package com.example.Real_Estate_Listings_API.repository;

import com.example.Real_Estate_Listings_API.dto.CityReportDto;
import com.example.Real_Estate_Listings_API.entity.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    @Query("SELECT l FROM Listing l WHERE " +
            "(:city IS NULL OR LOWER(l.city) = LOWER(:city)) AND " +
            "(:minPrice IS NULL OR l.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR l.price <= :maxPrice) AND " +
            "(:type IS NULL OR LOWER(l.type) = LOWER(:type))")
    Page<Listing> findWithFilters(
            @Param("city") String city,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("type") String type,
            Pageable pageable
    );

    @Query(value = "SELECT city AS city, COUNT(*) AS activeCount " +
            "FROM listings " +
            "WHERE status = 'ACTIVE' AND deleted_at IS NULL " +
            "GROUP BY city", nativeQuery = true)
    List<CityReportDto> getActiveListingsCountByCity();
}
