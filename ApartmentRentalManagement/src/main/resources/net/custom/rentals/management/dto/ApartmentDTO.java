package net.custom.rentals.management.dto;

import java.math.BigDecimal;

public class ApartmentDTO {

    private Long id;
    private String name;
    private String address;
    private Integer rooms;
    private BigDecimal rent;
    private String description;

    public ApartmentDTO() {
    }

    public ApartmentDTO(Long id, String name, String address, Integer rooms, BigDecimal rent, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.rent = rent;
        this.description = description;
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

    @Override
    public String toString() {
        return "ApartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", rent=" + rent +
                ", description='" + description + '\'' +
                '}';
    }
}
