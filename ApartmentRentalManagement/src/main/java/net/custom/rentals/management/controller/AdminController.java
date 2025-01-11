package net.custom.rentals.management.controller;

import net.custom.rentals.management.service.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private TenantService tenantService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private RentPaymentService rentPaymentService;
    @Autowired
    private MaintenanceRequestService maintenanceRequestService;
    @Autowired
    private UserService userService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/admin_dashboard")
    public String adminDashboard(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();  // getting the logged-in username
        model.addAttribute("username", username);
        
        return "admin_dashboard";
    }

    // --------- Tenant CRUD ---------
    
    @GetMapping("/admin/tenants")
    public String viewTenants(Model model) {
        model.addAttribute("tenants", tenantService.getAllTenants());
        return "admin/tenants";
    }

    @GetMapping("/tenant/delete/{id}")
    public String deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
        return "redirect:/admin/tenants";
    }

    // --------- Apartment CRUD ---------

    @GetMapping("/admin/apartments")
    public String viewApartments(Model model) {
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "admin/apartments";
    }

    @GetMapping("/apartment/delete/{id}")
    public String deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
        return "redirect:/admin/apartments";
    }

    // --------- Rent Payment CRUD ---------

    @GetMapping("/admin/rentpayments")
    public String viewRentPayments(Model model) {
        model.addAttribute("rentPayments", rentPaymentService.getAllRentPayments());
        return "admin/rentpayments";
    }

    @GetMapping("/rentpayment/delete/{id}")
    public String deleteRentPayment(@PathVariable Long id) {
        rentPaymentService.deleteRentPayment(id);
        return "redirect:/admin/rentpayments";
    }

    // --------- Maintenance Request CRUD ---------

    @GetMapping("/admin/maintenancerequests")
    public String viewMaintenanceRequests(Model model) {
        model.addAttribute("maintenanceRequests", maintenanceRequestService.getAllMaintenanceRequests());
        return "admin/maintenancerequests";
    }

    @GetMapping("/maintenancerequest/delete/{id}")
    public String deleteMaintenanceRequest(@PathVariable Long id) {
        maintenanceRequestService.deleteMaintenanceRequest(id);
        return "redirect:/admin/maintenancerequests";
    }

    // --------- User CRUD ---------

    @GetMapping("/admin/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
