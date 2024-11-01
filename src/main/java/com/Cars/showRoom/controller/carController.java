package com.Cars.showRoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    // list cars with show room detailes
    @GetMapping("/cars/{id}")
    public ResponseEntity<?> listCars(Pageable pageable,
    @RequestParam(required = false) String vin,
    @PathVariable String id,
    @RequestParam(required = false) String maker,
    @RequestParam(required = false) String model,
    @RequestParam(required = false) String modelYear,
    @RequestParam(required = false) String showroomName,
    @RequestParam(required = false) String contactNumber) {
        log.info("List cars with show room detailes");
        return new ResponseEntity<>(carService.listCars(pageable, vin, id, maker, model, modelYear, showroomName, contactNumber), HttpStatus.OK);
    }
    
}
