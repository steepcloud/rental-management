package net.custom.rentals.management.controller;

import net.custom.rentals.management.exception.NotFoundException;
import net.custom.rentals.management.model.Apartment;
import net.custom.rentals.management.model.Tenant;
import net.custom.rentals.management.service.TenantService;
import net.custom.rentals.management.service.ApartmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;
    
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/create")
    public String createTenantForm(Model model) {
        model.addAttribute("tenant", new Tenant());
        List<Apartment> apartments = apartmentService.getAllApartments();
        model.addAttribute("apartments", apartments);
        return "tenants/create_tenant";
    }

    @PostMapping("/create")
    public String createTenant(@RequestParam("apartmentId") Long apartmentId, @ModelAttribute Tenant tenant) {
        try {
            if (apartmentId != null) {
                Apartment apartment = apartmentService.getApartmentById(apartmentId);
                tenant.setApartment(apartment);
            }
            tenantService.saveTenant(tenant);
            return "redirect:/admin/tenants";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/edit/{id}")
    public String editTenantForm(@PathVariable Long id, Model model) {
        Tenant tenant = tenantService.getTenantById(id)
        		.orElseThrow(() -> new NotFoundException("Tenant not found"));
        List<Apartment> apartments = apartmentService.getAllApartments();
        model.addAttribute("tenant", tenant);
        model.addAttribute("apartments", apartments);
        return "tenants/edit_tenant";
    }

    @PostMapping("/edit")
    public String updateTenant(@RequestParam("apartmentId") Long apartmentId, @ModelAttribute Tenant tenant) {
    	try {
            if (apartmentId != null) {
                Apartment apartment = apartmentService.getApartmentById(apartmentId);
                tenant.setApartment(apartment);
            }
            tenantService.saveTenant(tenant);
            return "redirect:/admin/tenants";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
