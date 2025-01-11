package net.custom.rentals.management.service;

import net.custom.rentals.management.exception.NotFoundException;
import net.custom.rentals.management.model.RentPayment;
import net.custom.rentals.management.repository.RentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentPaymentService {

    @Autowired
    private RentPaymentRepository rentPaymentRepository;
    
    public RentPaymentService(RentPaymentRepository rentPaymentRepository) {
    	this.rentPaymentRepository = rentPaymentRepository;
    }
    
    @Transactional(readOnly = true)
    public List<RentPayment> findByTenantId(Long tenantId) {
        return rentPaymentRepository.findByTenantId(tenantId);
    }
    
    @Transactional(readOnly = true)
    public List<RentPayment> getAllRentPayments() {
        return rentPaymentRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public RentPayment getRentPaymentById(Long id) {
        Optional<RentPayment> rentPayment = rentPaymentRepository.findById(id);
        return rentPayment.orElse(null);
    }
    
    @Transactional
    public RentPayment saveRentPayment(RentPayment rentPayment) {
    	if (rentPayment.getId() != null) {
            RentPayment existingRentPayment = rentPaymentRepository.findById(rentPayment.getId())
                .orElseThrow(() -> new NotFoundException("RentPayment with ID " + rentPayment.getId() + " not found"));

            existingRentPayment.setTenant(rentPayment.getTenant());
            existingRentPayment.setAmount(rentPayment.getAmount());
            existingRentPayment.setPaymentDate(rentPayment.getPaymentDate());
            
            return rentPaymentRepository.save(existingRentPayment);
    	} else {
            return rentPaymentRepository.save(rentPayment);
        }
    }
    
    @Transactional
    public void deleteRentPayment(Long id) {
        rentPaymentRepository.deleteById(id);
    }
}
