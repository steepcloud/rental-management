package net.custom.rentals.management.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "maintenance_requests")
public class MaintenanceRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Apartment must not be null")
    private Apartment apartment;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotNull(message = "Description must not be null")
    @Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters")
    private String description;

    @Column(nullable = false)
    private String status = "PENDING";
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public MaintenanceRequest() {
        this.createdAt = LocalDateTime.now();
    }

    public MaintenanceRequest(Apartment apartment, String description) {
        this.apartment = apartment;
        this.description = description;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "id=" + id +
                ", apartment=" + (apartment != null ? apartment.getId() : "null") +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
