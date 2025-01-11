package net.custom.rentals.management.repository;

import net.custom.rentals.management.model.MaintenanceRequest;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {

    List<MaintenanceRequest> findByApartmentId(Long apartmentId);
    /**
    @Query("SELECT mr FROM MaintenanceRequest mr WHERE mr.status = 'PENDING'")
    List<MaintenanceRequest> findPendingRequests();
    
    List<MaintenanceRequest> findByStatus(String status);
    
    List<MaintenanceRequest> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    List<MaintenanceRequest> findByDescriptionContaining(String keyword);
    
    List<MaintenanceRequest> findByApartmentIdAndStatus(Long apartmentId, String status);
    
    List<MaintenanceRequest> findByCreatedAtAfterAndStatus(LocalDateTime date, String status);
    
    List<MaintenanceRequest> findTop5ByOrderByCreatedAtDesc();
    **/
    long countByApartmentId(Long apartmentId);
    
    // @Modifying
    // @Query("UPDATE MaintenanceRequest mr SET mr.status = :status WHERE mr.id = :id")
    // void updateStatusById(@Param("id") Long id, @Param("status") String status);
    
    void deleteById(Long id);

    void deleteByApartmentId(Long apartmentId);
}
