package net.custom.rentals.management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.custom.rentals.management.model.User;
import net.custom.rentals.management.service.UserService;

@Controller
public class LoginController {
	
	private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        if (userService.validateUser(username, password)) {

            User user = userService.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found after validation"));

            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole().name());

            if (user.getRole().name().equals("ROLE_ADMIN")) {
                System.out.println("Redirecting to admin dashboard...");
                return "redirect:/admin_dashboard";
            } else {
                return "redirect:/user/dashboard";
            }
        } else {
            model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
            return "login";
        }
    }
}
