package net.custom.rentals.management.dto;

import java.time.LocalDateTime;

public class MaintenanceRequestDTO {

    private Long id;
    private Long apartmentId;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    public MaintenanceRequestDTO() {
    }

    public MaintenanceRequestDTO(Long id, Long apartmentId, String description, String status, LocalDateTime createdAt) {
        this.id = id;
        this.apartmentId = apartmentId;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
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
        return "MaintenanceRequestDTO{" +
                "id=" + id +
                ", apartmentId=" + apartmentId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
