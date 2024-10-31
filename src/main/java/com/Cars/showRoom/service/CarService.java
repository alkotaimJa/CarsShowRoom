package com.Cars.showRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.Cars.showRoom.entity.Car;
import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.repository.CarRepository;
import com.Cars.showRoom.repository.CarShowroomRepository;

import jakarta.validation.Valid;

import com.Cars.showRoom.util.CarShowroomUtils;


@Service
@Validated
public class CarService {

    @Autowired
    private CarRepository carRepository;  
    @Autowired
    private CarShowroomRepository carShowroomRepository;

    public Car createCar(@Valid Car car) {
        CarShowroom showroom = CarShowroomUtils.checkAndReturnShowRoom(car.getCarShowroom().getCommercial_registration_number(), carShowroomRepository);
        car.setCarShowroom(showroom);
        return carRepository.save(car);
    }

    
}
