package net.custom.rentals.management.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.custom.rentals.management.model.Tenant;
import net.custom.rentals.management.security.CustomUserDetails;
import net.custom.rentals.management.service.TenantService;

@Controller
public class UserTenantController {

	@Autowired
	private TenantService tenantService;
	
	@GetMapping("/tenants/info")
	public String tenantInfo(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		net.custom.rentals.management.model.User user = customUserDetails.getUser();
	    
	    Tenant tenant = tenantService.getTenantInfo(user.getEmail());
	    
	    model.addAttribute("tenant", tenant);
	    
	    return "frontend/user/tenants/info";
	}
}
