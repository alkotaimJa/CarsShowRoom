package com.Cars.showRoom.DTO;

public class CarShowroomDetailsDTO {
    private String vin;
    private String maker;
    private String model;
    private Integer modelYear;
    private Double price;
    private String showroomName;
    private String contactNumber;

    // Constructor
    public CarShowroomDetailsDTO(String vin, String maker, String model, Integer modelYear, Double price, String showroomName, String contactNumber) {
        this.vin = vin;
        this.maker = maker;
        this.model = model;
        this.modelYear = modelYear;
        this.price = price;
        this.showroomName = showroomName;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
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
    public Integer getModelYear() {
        return modelYear;
    }
    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCarShowroomName() {
        return showroomName;
    }
    public void setCarShowroomName(String carShowroomName) {
        this.showroomName = carShowroomName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
