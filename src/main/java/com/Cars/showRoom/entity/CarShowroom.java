package com.Cars.showRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "car_showroom", uniqueConstraints = {
        @UniqueConstraint(columnNames = "commercial_registration_number")
})
public class CarShowroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotNull(message = "Commercial registration number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Commercial registration number must be 10 digits")
    private String commercial_registration_number;

    @Size(max = 100, message = "Manager name must not exceed 100 characters")
    private String manager_name;

    @NotNull(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{1,15}$", message = "Contact number must be numeric and at most 15 digits")
    private String contact_number;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    private boolean deleted;

    // constructor
    public CarShowroom(String name, String commercial_registration_number, String manager_name, String contact_number, String address) {
        this.name = name;
        this.commercial_registration_number = commercial_registration_number;
        this.manager_name = manager_name;
        this.contact_number = contact_number;
        this.address = address;
        this.deleted = false;
    }
    // Empty constructor
    public CarShowroom() {
    }

    // Getters and Setters
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

    public String getCommercial_registration_number() {
        return commercial_registration_number;
    }
    public boolean getDeleted() {
        return deleted;
    }

    public void setCommercial_registration_number(String commercial_registration_number) {
        this.commercial_registration_number = commercial_registration_number;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setDeleted(boolean Deleted) {
        this.deleted = Deleted;
    }
}
