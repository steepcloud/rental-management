package net.custom.rentals.management.repository;

import net.custom.rentals.management.model.Apartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomQueriesRepository {

    // @Query("SELECT a FROM Apartment a WHERE a.size >= ?1 AND a.rent <= ?2")
    // List<Apartment> findApartmentsBySizeAndRent(Double minSize, Double maxRent);
}
