package net.custom.rentals.management.repository;

import net.custom.rentals.management.model.RentPayment;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentPaymentRepository extends JpaRepository<RentPayment, Long> {
	
    List<RentPayment> findByTenantId(Long tenantId);

    // List<RentPayment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
    
    // List<RentPayment> findByApartmentId(Long apartmentId);
    /**
    List<RentPayment> findByAmountPaidGreaterThanEqual(Double amount);

    List<RentPayment> findByStatus(String status);
    
    List<RentPayment> findByTenantIdAndPaymentDateBetween(Long tenantId, LocalDate startDate, LocalDate endDate);

    // List<RentPayment> findByTenantIdAndApartmentId(Long tenantId, Long apartmentId);

    List<RentPayment> findByPaymentDateBeforeAndStatus(LocalDate date, String status);

    long countByTenantId(Long tenantId);

    List<RentPayment> findByTenantIdAndAmountPaidGreaterThan(Long tenantId, Double amount);

    List<RentPayment> findTop5ByOrderByPaymentDateDesc();

    List<RentPayment> findByTenantIdAndApartmentIdAndAmountPaid(Long tenantId, Long apartmentId, Double amount);
	**/
    void deleteById(Long id);

    void deleteByTenantId(Long tenantId);

    // @Modifying
    // @Query("UPDATE RentPayment rp SET rp.amountPaid = :amountPaid, rp.status = :status WHERE rp.id = :id")
    // void updateRentPayment(@Param("id") Long id, @Param("amountPaid") Double amountPaid, @Param("status") String status);
}
