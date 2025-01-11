package net.custom.rentals.management.dto;

public class TenantDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private Long apartmentId;

    public TenantDTO() {
    }

    public TenantDTO(Long id, String name, String phone, String email, Long apartmentId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.apartmentId = apartmentId;
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
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public String toString() {
        return "TenantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", apartmentId=" + apartmentId +
                '}';
    }
}
