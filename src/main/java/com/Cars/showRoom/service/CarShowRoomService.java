package com.Cars.showRoom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Cars.showRoom.DTO.UpdateCarShowroomDTO;
import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.exception.ResourceNotFoundException;
import com.Cars.showRoom.projection.CarShowroomProjection;
import com.Cars.showRoom.repository.CarShowroomRepository;
import com.Cars.showRoom.util.CarShowroomUtils;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@Service
@Validated
public class CarShowRoomService {
    
    @Autowired
    private CarShowroomRepository carShowroomRepository;

    // get all show rooms
    public Page<CarShowroomProjection> getShowrooms(Pageable pageable) {
        Page<CarShowroomProjection> showroomsPage = carShowroomRepository.findAllShowrooms(pageable);
        if (showroomsPage.isEmpty()) {
            throw new ResourceNotFoundException("No showrooms found");
        }
        return showroomsPage;
    }

    // create a show room
    public CarShowroom createShowroom(@Valid CarShowroom carShowroom) {
        // a better sloution needs to be found, better than calling db 2 times 
       if(CarShowroomUtils.isCommercialRegistrationNumberExists(carShowroom.getCommercial_registration_number(), carShowroomRepository)) {
            throw new ValidationException("Showroom with commercial registration number " + carShowroom.getCommercial_registration_number() + " already exists");
        }
       return carShowroomRepository.save(carShowroom);
    }

    // get showroom
    public CarShowroom getShowroom(String commercialRegistrationNumber) {
        CarShowroom showroom = checkAndReturnShowRoom(commercialRegistrationNumber);
        return showroom;
    }

    public CarShowroom deleteShowroom(String commercial_registration_number) {
        CarShowroom showroom = checkAndReturnShowRoom(commercial_registration_number);
        showroom.setDeleted(true);
        return carShowroomRepository.save(showroom);
    }

    public CarShowroom updateShowroom(String commercialRegistrationNumber, UpdateCarShowroomDTO updateDTO) {
        CarShowroom showroom = checkAndReturnShowRoom(commercialRegistrationNumber);
        if (updateDTO.getContact_number() != null) {
            showroom.setContact_number(updateDTO.getContact_number());
        }
        if (updateDTO.getManager_name() != null) {
            showroom.setManager_name(updateDTO.getManager_name());
        }
        if (updateDTO.getAddress() != null) {
            showroom.setAddress(updateDTO.getAddress());
        }
        return carShowroomRepository.save(showroom);
    }
    
    private CarShowroom checkAndReturnShowRoom(String commercial_registration_number) {
        CarShowroom showroom = carShowroomRepository.findCarShowroomByCommercialRegistrationNumber(commercial_registration_number);
        if (showroom == null) {
            throw new ResourceNotFoundException("Showroom not found");
        }
        return showroom;
    }
    
}
