package net.custom.rentals.management.usercontroller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import net.custom.rentals.management.exception.NotFoundException;
import net.custom.rentals.management.model.Apartment;
import net.custom.rentals.management.model.Tenant;
import net.custom.rentals.management.model.User;
import net.custom.rentals.management.service.UserService;
import net.custom.rentals.management.service.ApartmentService;
import net.custom.rentals.management.service.TenantService;

@Controller
public class UserDashboardController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private TenantService tenantService;
	
	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping("/user/dashboard")
	public String dashboard(Model model) {
		User currentUser = userService.getCurrentUser();
        
        //Tenant tenant = tenantService.getTenantById(currentUser.getId())
        //		.orElseThrow(() -> new NotFoundException("Tenant not found."));

		Tenant tenant = tenantService.getTenantInfo(currentUser.getEmail());
		
		model.addAttribute("tenant", tenant);
	    
		if (tenant != null && tenant.getApartment() != null) {
	        model.addAttribute("apartment", tenant.getApartment());
	    } else {
	        model.addAttribute("apartment", null);
	    }
	    
	    Optional<Apartment> apartmentOptional = apartmentService.findApartmentById(currentUser.getId());
	    apartmentOptional.ifPresent(apartment -> model.addAttribute("apartment", apartment));

	    model.addAttribute("user", currentUser);
        
        return "frontend/user/dashboard";
	}
	
	@GetMapping("/user/profile")
	public String profile(Model model) {
		model.addAttribute("user", userService.getCurrentUser());
		return "frontend/user/profile";
	}
	
	@PostMapping("/user/profile/update")
	public String updateProfile(@Valid  @ModelAttribute User user,
								BindingResult result, Model model) {
		if (result.hasErrors()) {
	        model.addAttribute("user", user);
	        return "frontend/user/profile";
	    }
		userService.saveUser(user);
		return "redirect:/user/profile";
	}
}
