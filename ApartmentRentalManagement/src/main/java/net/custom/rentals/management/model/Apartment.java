package net.custom.rentals.management.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;


@Entity
@Table(name = "apartments")
public class Apartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment for ID
	private Long id;
	
	@NotNull(message = "Apartment Name is required.")
    @Size(min = 1, message = "Apartment Name cannot be empty.")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message = "Address is required.")
    @Size(min = 1, message = "Address cannot be empty.")
	@Column(nullable = false)
	private String address;
	
	@NotNull(message = "Number of rooms is required.")
    @Min(value = 1, message = "Number of rooms must be a positive integer.")
	@Column(nullable = false)
	private Integer rooms;
	
	@NotNull(message = "Rent amount is required.")
    @DecimalMin(value = "0.01", message = "Rent must be a positive number.")
	@Column(nullable = false)
	private BigDecimal rent;
	
	@Size(max = 500, message = "Description should not exceed 500 characters.")
	@Column
	private String description;
	
	@Pattern(regexp = "^images/.+\\.(jpg|jpeg|png|bmp)$", message = "Invalid image path. Should be in the format: images/img_name.jpg/.png/.bmp/.jpeg")
	@Column(name = "image_path")
	private String imagePath;
	
	public Apartment() {
	}
	
	public Apartment(
			String name,
			String address, 
			Integer rooms, 
			BigDecimal rent,
			String description,
			String imagePath) {
		this.name = name;
		this.address = address;
		this.rooms = rooms;
		this.rent = rent;
		this.description = description;
		this.imagePath = imagePath;
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
	
	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", rent=" + rent +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
