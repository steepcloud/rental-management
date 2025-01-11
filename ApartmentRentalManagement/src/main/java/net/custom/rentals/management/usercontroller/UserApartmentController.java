package net.custom.rentals.management.usercontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.custom.rentals.management.exception.NotFoundException;
import net.custom.rentals.management.model.Apartment;
import net.custom.rentals.management.security.CustomUserDetails;
import net.custom.rentals.management.service.ApartmentService;

@Controller
public class UserApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping("/apartments/list")
	public String listApartments(Model model) {
		model.addAttribute("apartments", apartmentService.getAllApartments());
		return "frontend/user/apartments/list";
	}
	
	@GetMapping("/apartments/details")
	public String apartmentDetails(@RequestParam Long apartmentId, Model model) {
		Apartment apartment = apartmentService.findApartmentById(apartmentId)
                .orElseThrow(() -> new NotFoundException("Apartment not found"));
		model.addAttribute("apartment", apartment);
		return "frontend/user/apartments/details";
	}
	
	@PostMapping("/apartments/rent")
	public String rentApartment(
            @RequestParam Long apartmentId,
            @RequestParam String name,
            @RequestParam String phone,
            HttpServletRequest request) {
		
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = customUserDetails.getUser().getEmail();
        
        apartmentService.rentApartment(apartmentId, name, phone, email);

        return "redirect:/apartments/list";
    }
}
