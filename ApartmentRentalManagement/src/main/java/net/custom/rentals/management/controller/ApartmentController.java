package net.custom.rentals.management.controller;

import net.custom.rentals.management.model.Apartment;
import net.custom.rentals.management.service.ApartmentService;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/create")
    public String showCreateApartmentForm(Model model) {
        model.addAttribute("apartment", new Apartment());
        return "apartments/create_apartment";
    }

    @PostMapping("/create")
    public String createApartment(@RequestParam("name") String name,
                                  @RequestParam("address") String address,
                                  @RequestParam("rooms") int rooms,
                                  @RequestParam("rent") BigDecimal rent,
                                  @RequestParam(value = "description", required = false) String description,
                                  @RequestParam("imagePath") String imagePath) {
        try {
        	Apartment apartment = new Apartment(
                    name,
                    address,
                    rooms,
                    rent,
                    description,
                    imagePath
            );
            apartmentService.createApartment(apartment);

            return "redirect:/admin/apartments";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/edit/{id}")
    public String editApartmentForm(@PathVariable Long id, Model model) {
        Apartment apartment = apartmentService.getApartmentById(id);
        model.addAttribute("apartment", apartment);
        return "apartments/edit_apartment";
    }

    @PostMapping("/edit")
    public String updateApartment(@ModelAttribute Apartment apartment) {
        try {
        	if (apartment.getId() == null) {
                throw new IllegalArgumentException("Apartment ID must not be null");
            }
            apartmentService.saveApartment(apartment);

            return "redirect:/admin/apartments";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
