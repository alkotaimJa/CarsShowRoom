package com.Cars.showRoom.util;

import com.Cars.showRoom.DTO.UpdateCarShowroomDTO;
import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.repository.CarShowroomRepository;

public class CarShowroomUtils {

 private CarShowroomUtils() {
        // Private constructor to prevent instantiation
    }
    
 public static boolean isCommercialRegistrationNumberExists(String commercialRegistrationNumber, CarShowroomRepository repository) {
    if(repository.findCarShowroomByCommercialRegistrationNumber(commercialRegistrationNumber) != null){
        return true;
    }
    return false;
 }
 
}
