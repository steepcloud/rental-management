package net.custom.rentals.management.repository;

import net.custom.rentals.management.model.Tenant;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Optional<Tenant> findByEmail(String email);
    
    Optional<Tenant> findByName(String name);

    List<Tenant> findByNameContaining(String name);
    /**
    @Query("SELECT t FROM Tenant t WHERE t.active = true")
    List<Tenant> findActiveTenants();
    
    Optional<Tenant> findById(Long id);
    
    List<Tenant> findByActiveTrueAndNameContaining(String name);

    List<Tenant> findByCreatedAtAfter(LocalDateTime date);

    Optional<Tenant> findByActiveTrueAndEmail(String email);

    List<Tenant> findByActiveFalse();

    List<Tenant> findByDateOfBirthBefore(LocalDate date);

    List<Tenant> findByApartmentId(Long apartmentId);

    List<Tenant> findByRentPaymentsPaymentDateBefore(LocalDate date);

    long countByActiveTrue();

    List<Tenant> findByOutstandingRentGreaterThanEqual(Double outstandingAmount);

    List<Tenant> findByRentPaymentsPaymentDateBetween(LocalDate startDate, LocalDate endDate);

    @Modifying
    @Query("UPDATE Tenant t SET t.name = :name, t.email = :email WHERE t.id = :id")
    void updateTenant(@Param("id") Long id, @Param("name") String name, @Param("email") String email);
    **/
    void deleteById(Long id);
}
