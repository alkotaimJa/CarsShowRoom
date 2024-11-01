package com.Cars.showRoom.service;

import java.beans.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.Cars.showRoom.DTO.CarShowroomDetailsDTO;
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

    // create a car
    public Car createCar(@Valid Car car) {
        CarShowroom showroom = CarShowroomUtils.checkAndReturnShowRoom(car.getCarShowroom().getCommercial_registration_number(), carShowroomRepository);
        car.setCarShowroom(showroom);
        return carRepository.save(car);
    }

    // list cars with show room detailes
    @Transient
    public Page<CarShowroomDetailsDTO> listCars(Pageable pageable, String vin, String id, String maker, String model, String modelYear, String showroomName,String  contactNumber) {
        // check if id is coreact first
        CarShowroomUtils.checkAndReturnShowRoomById(id, carShowroomRepository);
        // if showroom exists, proceed to fetch cars
         return carRepository.findAllWithShowroomDetails(pageable,  vin, id,  maker, model, modelYear, showroomName, contactNumber);

    }

    
}
