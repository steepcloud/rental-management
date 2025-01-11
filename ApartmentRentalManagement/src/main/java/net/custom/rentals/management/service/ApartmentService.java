package net.custom.rentals.management.service;

import net.custom.rentals.management.exception.NotFoundException;
import net.custom.rentals.management.model.Apartment;
import net.custom.rentals.management.model.Tenant;
import net.custom.rentals.management.repository.ApartmentRepository;
import net.custom.rentals.management.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;
    
    @Autowired
    private TenantRepository tenantRepository;
    
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    // retrieve all apartments
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }
    
    public void createApartment(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    // save a new apartment or update an existing one
    @Transactional
    public void saveApartment(Apartment updatedApartment) {
    	Apartment existingApartment = apartmentRepository.findById(updatedApartment.getId())
    	        .orElseThrow(() -> new NotFoundException("Apartment with ID " + updatedApartment.getId() + " not found"));

    	existingApartment.setName(updatedApartment.getName());
    	existingApartment.setAddress(updatedApartment.getAddress());
    	existingApartment.setRooms(updatedApartment.getRooms());
    	existingApartment.setRent(updatedApartment.getRent());
    	existingApartment.setDescription(updatedApartment.getDescription());
    	existingApartment.setImagePath(updatedApartment.getImagePath());
    	
        apartmentRepository.save(existingApartment);
    }

    public Apartment getApartmentById(Long id) {
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        return apartment.orElse(null);
    }
    
    public Optional<Apartment> findApartmentById(Long id) {
        return apartmentRepository.findById(id);
    }
    
    // rent an apartment
    @Transactional
    public void rentApartment(Long apartmentId, String name, String phone, String email) {
    	Apartment apartment = apartmentRepository.findById(apartmentId)
    			.orElseThrow(() -> new NotFoundException("Apartment not found"));
    	
    	Tenant tenant = new Tenant();
    	tenant.setName(name);
    	tenant.setPhone(phone);
    	tenant.setEmail(email);
    	tenant.setApartment(apartment);
    	
    	tenantRepository.save(tenant);
    }

    @Transactional
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);
    }

    public List<Apartment> findByRentLessThanEqual(Double rent) {
        return apartmentRepository.findByRentLessThanEqual(rent);
    }
}
