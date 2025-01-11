package net.custom.rentals.management.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.custom.rentals.management.model.MaintenanceRequest;
import net.custom.rentals.management.service.ApartmentService;
import net.custom.rentals.management.service.MaintenanceRequestService;

@Controller
public class UserMaintenanceRequestController {

	@Autowired
	private MaintenanceRequestService maintenanceRequestService;
	
	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping("/user/maintenancerequests/list")
	public String listRequests(Model model) {
		model.addAttribute("requests", maintenanceRequestService.getAllMaintenanceRequests());
		return "frontend/user/maintenancerequests/list";
	}
	
	@GetMapping("/user/maintenancerequests/create")
	public String createRequest(Model model) {
		model.addAttribute("maintenanceRequest", new MaintenanceRequest());
		model.addAttribute("apartments", apartmentService.getAllApartments());
		return "frontend/user/maintenancerequests/create";
	}
	
	@PostMapping("/user/maintenancerequests/create")
	public String saveRequest(MaintenanceRequest maintenanceRequest) {
		 maintenanceRequestService.saveMaintenanceRequest(maintenanceRequest);
	     return "redirect:/user/maintenancerequests/list";
	}
	
	@GetMapping("/user/maintenancerequests/edit")
	public String editRequest(Long requestId, Model model) {
		MaintenanceRequest maintenanceRequest = maintenanceRequestService.getMaintenanceRequestById(requestId);
        model.addAttribute("maintenanceRequest", maintenanceRequest);
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "frontend/user/maintenancerequests/edit";
	}
	
	@PostMapping("/user/maintenancerequests/edit")
	public String updateRequest(MaintenanceRequest maintenanceRequest) {
		maintenanceRequestService.saveMaintenanceRequest(maintenanceRequest);
        return "redirect:/user/maintenancerequests/list";
	}
}
