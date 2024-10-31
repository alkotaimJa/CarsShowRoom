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

import jakarta.transaction.Transactional;
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
    @Transactional
    public CarShowroom createShowroom(@Valid CarShowroom carShowroom) {
       if(CarShowroomUtils.isCommercialRegistrationNumberExists(carShowroom.getCommercial_registration_number(), carShowroomRepository)) {
            throw new ValidationException("Showroom with commercial registration number " + carShowroom.getCommercial_registration_number() + " already exists");
        }
       return carShowroomRepository.save(carShowroom);
    }

    // get showroom
    @Transactional
    public CarShowroom getShowroom(String commercialRegistrationNumber) {
        CarShowroom showroom = CarShowroomUtils.checkAndReturnShowRoom(commercialRegistrationNumber, carShowroomRepository);
        return showroom;
    }

    // soft delete showroom
    @Transactional
    public CarShowroom deleteShowroom(String commercial_registration_number) {
        CarShowroom showroom = CarShowroomUtils.checkAndReturnShowRoom(commercial_registration_number, carShowroomRepository);
        showroom.setDeleted(true);
        return carShowroomRepository.save(showroom);
    }

    // update showroom
    @Transactional
    public CarShowroom updateShowroom(String commercialRegistrationNumber, UpdateCarShowroomDTO updateDTO) {
        CarShowroom showroom = CarShowroomUtils.checkAndReturnShowRoom(commercialRegistrationNumber, carShowroomRepository);
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
        
}
