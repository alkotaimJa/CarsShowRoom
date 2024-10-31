package com.Cars.showRoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Cars.showRoom.entity.Car;
import com.Cars.showRoom.service.CarService;

import jakarta.validation.Valid;

@RestController
@Valid
public class carController {
    private static final Logger log = LoggerFactory.getLogger(showRoomController.class);

    @Autowired
    private CarService carService;
    
    // create a car 
    @PostMapping("/car")
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car) {
        log.info("Create a car: " + car.toString());
        Car newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
    
    
}
