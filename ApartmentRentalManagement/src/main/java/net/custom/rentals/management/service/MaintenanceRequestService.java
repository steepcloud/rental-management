package net.custom.rentals.management.service;

import net.custom.rentals.management.model.MaintenanceRequest;
import net.custom.rentals.management.repository.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaintenanceRequestService {

    @Autowired
    private MaintenanceRequestRepository maintenanceRequestRepository;
    
    public MaintenanceRequestService(MaintenanceRequestRepository maintenanceRequestRepository) {
        this.maintenanceRequestRepository = maintenanceRequestRepository;
    }

    public List<MaintenanceRequest> findByApartmentId(Long apartmentId) {
        return maintenanceRequestRepository.findByApartmentId(apartmentId);
    }

    public List<MaintenanceRequest> getAllMaintenanceRequests() {
        return maintenanceRequestRepository.findAll();
    }
    
    public MaintenanceRequest getMaintenanceRequestById(Long id) {
        Optional<MaintenanceRequest> maintenanceRequest = maintenanceRequestRepository.findById(id);
        return maintenanceRequest.orElse(null);
    }
    
    @Transactional
    public MaintenanceRequest saveMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
        return maintenanceRequestRepository.save(maintenanceRequest);
    }
    
    @Transactional
    public void deleteMaintenanceRequest(Long id) {
        maintenanceRequestRepository.deleteById(id);
    }
}
