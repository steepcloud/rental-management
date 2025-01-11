package net.custom.rentals.management.controller;

import net.custom.rentals.management.model.Apartment;
import net.custom.rentals.management.model.MaintenanceRequest;
import net.custom.rentals.management.service.MaintenanceRequestService;
import net.custom.rentals.management.service.ApartmentService;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MaintenanceRequestController {

    private final MaintenanceRequestService maintenanceRequestService;
    private final ApartmentService apartmentService;

    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService,
                                        ApartmentService apartmentService) {
        this.maintenanceRequestService = maintenanceRequestService;
        this.apartmentService = apartmentService;
    }

    @GetMapping("/maintenancerequest/create")
    public String createMaintenanceRequestForm(Model model) {
        model.addAttribute("maintenanceRequest", new MaintenanceRequest());
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "maintenancerequests/create_maintenancerequest";
    }

    @PostMapping("/maintenancerequest/create")
    public String createMaintenanceRequest(@ModelAttribute MaintenanceRequest maintenanceRequest,
    										@RequestParam Long apartmentId) {
    	maintenanceRequest.setStatus("PENDING");
    	
    	LocalDateTime now = LocalDateTime.now();
        maintenanceRequest.setCreatedAt(now);
        
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        maintenanceRequest.setApartment(apartment);
        
        maintenanceRequestService.saveMaintenanceRequest(maintenanceRequest);
        return "redirect:/admin/maintenancerequests";
    }
    
    @GetMapping("/maintenancerequest/edit/{id}")
    public String editMaintenanceRequestForm(@PathVariable Long id, Model model) {

        MaintenanceRequest maintenanceRequest = maintenanceRequestService.getMaintenanceRequestById(id);
        model.addAttribute("maintenanceRequest", maintenanceRequest);
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "maintenancerequests/edit_maintenancerequest";
    }

    @PostMapping("/maintenancerequest/edit")
    public String updateMaintenanceRequest(@ModelAttribute MaintenanceRequest maintenanceRequest,
    									   @RequestParam Long apartmentId) {
    	        
    	MaintenanceRequest existingRequest = maintenanceRequestService.getMaintenanceRequestById(apartmentId);

        if (existingRequest == null) {
            throw new IllegalArgumentException("Maintenance request with ID " + maintenanceRequest.getId() + " not found.");
        }
        
        existingRequest.setDescription(maintenanceRequest.getDescription());
        existingRequest.setStatus(maintenanceRequest.getStatus());
        
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        existingRequest.setApartment(apartment);
        
        
        maintenanceRequestService.saveMaintenanceRequest(existingRequest);
        
        return "redirect:/admin/maintenancerequests";
    }
}
