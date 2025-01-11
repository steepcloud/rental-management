package net.custom.rentals.management.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.custom.rentals.management.model.RentPayment;
import net.custom.rentals.management.model.Tenant;
import net.custom.rentals.management.service.RentPaymentService;
import net.custom.rentals.management.service.TenantService;
import net.custom.rentals.management.exception.NotFoundException;

@Controller
public class RentPaymentController {
	
    private final RentPaymentService rentPaymentService;
    private final TenantService tenantService;

    public RentPaymentController(RentPaymentService rentPaymentService, TenantService tenantService) {
        this.rentPaymentService = rentPaymentService;
        this.tenantService = tenantService;
    }

    @GetMapping("/rentpayment/create")
    public String createRentPaymentForm(Model model) {
        model.addAttribute("rentPayment", new RentPayment());
        model.addAttribute("tenants", tenantService.getAllTenants());
        return "rentpayments/create_rentpayment";
    }

    @PostMapping("/rentpayment/create")
    public String createRentPayment(@RequestParam Long tenantId,
                                    @RequestParam BigDecimal amount,
                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate paymentDate,
                                    @ModelAttribute RentPayment rentPayment) {

        Tenant tenant = tenantService.getTenantById(tenantId).orElseThrow(() -> new NotFoundException("Tenant not found"));

        rentPayment.setTenant(tenant);
        rentPayment.setAmount(amount);
        rentPayment.setPaymentDate(paymentDate);

        rentPaymentService.saveRentPayment(rentPayment);
        return "redirect:/admin/rentpayments";
    }
    
    @GetMapping("/rentpayment/edit/{id}")
    public String editRentPaymentForm(@PathVariable Long id, Model model) {
        RentPayment rentPayment = rentPaymentService.getRentPaymentById(id);
        if (rentPayment == null) {
            throw new NotFoundException("RentPayment not found");
        }
        
        Tenant tenant = tenantService.getTenantById(rentPayment.getTenant().getId())
                .orElseThrow(() -> new NotFoundException("Tenant not found"));
        rentPayment.setTenant(tenant);
        
        model.addAttribute("rentPayment", rentPayment);
        model.addAttribute("tenants", tenantService.getAllTenants());
        return "rentpayments/edit_rentpayment";
    }

    @PostMapping("/rentpayment/edit")
    public String updateRentPayment(@ModelAttribute RentPayment rentPayment, @RequestParam Long tenantId) {
    	Tenant tenant = rentPayment.getTenant();
    	
        if (tenant == null) {
            tenant = tenantService.getTenantById(tenantId)
                    .orElseThrow(() -> new NotFoundException("Tenant with ID " + tenantId + " not found"));
            
            rentPayment.setTenant(tenant);
            System.out.println("Tenant has been set to: " + tenant);
        } else {
            System.out.println("Tenant is: " + tenant);
        }
        
        rentPaymentService.saveRentPayment(rentPayment);
        return "redirect:/admin/rentpayments";
    }
}
