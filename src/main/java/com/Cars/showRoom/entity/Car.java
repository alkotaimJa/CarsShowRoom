package com.Cars.showRoom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "VIN is required")
    @Size(max = 25, message = "VIN must not exceed 25 characters")
    private String vin;

    @NotBlank(message = "Maker is required")
    @Size(max = 25, message = "Maker must not exceed 25 characters")
    private String maker;

    @NotBlank(message = "Model is required")
    @Size(max = 25, message = "Model must not exceed 25 characters")
    private String model;

    @NotNull(message = "Model year is required")
    @Min(value = 1886, message = "Model year must be greater than or equal to 1886")
    @Max(value = 9999, message = "Model year must be less than or equal to 9999")
    private Integer model_year;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "car_showroom_id", nullable = false)
    private CarShowroom carShowroom;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getModel_year() {
        return model_year;
    }

    public void setModel_year(Integer model_year) {
        this.model_year = model_year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarShowroom getCarShowroom() {
        return carShowroom;
    }

    public void setCarShowroom(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }
}


