package net.custom.rentals.management.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.custom.rentals.management.model.RentPayment;
import net.custom.rentals.management.service.RentPaymentService;
//import net.custom.rentals.management.exception.NotFoundException;

@Controller
public class UserRentPaymentController {

	@Autowired
	private RentPaymentService rentPaymentService;
	
	@GetMapping("/user/rentpayments/list")
	public String listRentPayments(Model model) {
		model.addAttribute("rentPayments", rentPaymentService.getAllRentPayments());
        return "frontend/user/rentpayments/list";
	}
	
	@GetMapping("/user/rentpayments/details")
	public String rentPaymentDetails(@RequestParam Long paymentId, Model model) {
		if (paymentId == null) {
	        throw new IllegalArgumentException("Payment ID must not be null!");
	    }
	    RentPayment rentPayment = rentPaymentService.getRentPaymentById(paymentId);
	    model.addAttribute("rentPayment", rentPayment);
	    return "frontend/user/rentpayments/details";
	}
}
