package net.custom.rentals.management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.custom.rentals.management.model.User;
import net.custom.rentals.management.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/public/home")
    public String showHomePage() {
        return "frontend/public/home";
    }
	
	@GetMapping("/public/about")
	public String showAboutPage() {
		return "frontend/public/about";
	}
	
	@GetMapping("/public/login")
	public String showLoginPage() {
		return "frontend/public/login";
	}
	
	@PostMapping("/public/login")
	public String login(@RequestParam String username,
						@RequestParam String password,
						Model model,
						HttpSession session) {
		if (userService.validateUser(username, password)) {
			session.setAttribute("username", username);
	        return "redirect:/user/dashboard";
	    } else {
	        model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
	        return "/frontend/public/login";
	    }
	}
	
	@GetMapping("/public/register")
	public String showRegisterPage() {
		return "frontend/public/register";
	}
	
	@PostMapping("/public/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            userService.saveUserPage(user);
            return "redirect:/public/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred during registration. Please try again.");
            return "frontend/public/register";
        }
    }
}
