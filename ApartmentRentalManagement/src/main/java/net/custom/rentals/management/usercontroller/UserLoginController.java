package net.custom.rentals.management.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
	
	@GetMapping("/user/login")
    public String showUserLoginPage() {
        return "frontend/public/login";
    }
}
