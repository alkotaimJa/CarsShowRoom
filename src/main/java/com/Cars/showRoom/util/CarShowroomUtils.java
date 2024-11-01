package com.Cars.showRoom.util;

import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.exception.ResourceNotFoundException;
import com.Cars.showRoom.repository.CarShowroomRepository;

import jakarta.validation.ValidationException;

public class CarShowroomUtils {

 private CarShowroomUtils() {
        // Private constructor to prevent instantiation
    }
    

 // check if commercial registration number exists
 public static boolean isCommercialRegistrationNumberExists(String commercialRegistrationNumber, CarShowroomRepository repository) {
    if(repository.findCarShowroomByCommercialRegistrationNumber(commercialRegistrationNumber) != null){
        return true;
    }
    return false;
 }

 // check if showroom exists and return it
 public static CarShowroom checkAndReturnShowRoom(String commercial_registration_number,  CarShowroomRepository carShowroomRepository) {
        CarShowroom showroom = carShowroomRepository.findCarShowroomByCommercialRegistrationNumberAndNotDeleted(commercial_registration_number);
        if (showroom == null) {
            throw new ResourceNotFoundException("Showroom not found");
        }
        return showroom;
    }

 // check if showroom exists and return it by it id
 public static CarShowroom checkAndReturnShowRoomById(String id, CarShowroomRepository carShowroomRepository) {
    try {
        Long showroomId = Long.parseLong(id);
        CarShowroom showroom = carShowroomRepository.findById(showroomId).orElseThrow(() -> 
            new ResourceNotFoundException("Showroom not found")
        );
        return showroom;
    } catch (NumberFormatException e) {
        throw new ValidationException("Invalid ID format: ID must be a number", e);
    }
}

}
