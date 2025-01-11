package net.custom.rentals.management.repository;

import net.custom.rentals.management.model.Apartment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    // List<Apartment> findByLocation(String location);

    // List<Apartment> findBySizeGreaterThanEqual(Double size);

    List<Apartment> findByRentLessThanEqual(Double rent);
}
