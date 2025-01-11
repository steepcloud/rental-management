package net.custom.rentals.management.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.regex.Matcher;
//import java.util.regex.Pattern;

@Entity
@Table(name = "tenants")
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "Name is mandatory")
    private String name;

	@Pattern(regexp = "^[+]?\\d{1,4}[-.\\s]?\\d{1,3}[-.\\s]?\\d{1,3}[-.\\s]?\\d{1,4}$", message = "Invalid phone number format")
    private String phone;

	@Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;

    public Tenant() {
    }
    
    public Tenant(String name, String phone, String email, Apartment apartment) {
        this.name = name;
        this.setPhone(phone);
        this.setEmail(email);
        this.apartment = apartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    	if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org|net)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", apartment=" + (apartment != null ? apartment.getId() : "null") +
                '}';
    }

    private boolean isValidPhone(String phone) {
        String regex = "^[+]?\\d{1,4}[-.\\s]?\\d{1,3}[-.\\s]?\\d{1,3}[-.\\s]?\\d{1,4}$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
