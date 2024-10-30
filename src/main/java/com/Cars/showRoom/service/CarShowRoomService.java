package com.Cars.showRoom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.projection.CarShowroomProjection;
import com.Cars.showRoom.repository.CarShowroomRepository;

@Service
public class CarShowRoomService {
    
    @Autowired
    private CarShowroomRepository carShowroomRepository;

    // get all show rooms
    public Page<CarShowroomProjection> getShowrooms(Pageable pageable) {
        return carShowroomRepository.findAllShowrooms(pageable);
    }

    // create a show room
    public CarShowroom createShowroom(CarShowroom carShowroom) {
        return carShowroomRepository.save(carShowroom);
    }

    
}
