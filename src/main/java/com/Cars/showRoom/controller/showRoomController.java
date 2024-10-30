package com.Cars.showRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.exception.ResourceNotFoundException;
import com.Cars.showRoom.projection.CarShowroomProjection;
import com.Cars.showRoom.service.CarShowRoomService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@Validated
public class showRoomController {
    private static final Logger log = LoggerFactory.getLogger(showRoomController.class);

    @Autowired
    private CarShowRoomService showRoomService;

    @GetMapping("/")
    public String helloShowRoom() {
        log.info("showRoomController controller called");
        return "Hello!!";
    }

    // Get all showrooms with pagination and sorting
    @GetMapping("/showrooms")
    public ResponseEntity<?> getAllShowRooms(Pageable pageable) {
        log.info("List showrooms with pagination and sorting: " + pageable.toString());
        Page<CarShowroomProjection> showroomsPage = showRoomService.getShowrooms(pageable);
        return new ResponseEntity<>(showroomsPage, HttpStatus.OK);
    }

    // get a spsific show room by commercial registration number
    @GetMapping("/showroom/{commercial_registration_number}")
    public ResponseEntity<?> getShowroomById(@PathVariable String commercial_registration_number) {
        log.info("Get showroom by commercial registration number: " + commercial_registration_number);
        CarShowroom showroom = showRoomService.getShowroom(commercial_registration_number);
        return new ResponseEntity<>(showroom, HttpStatus.OK);
    }


    // create a show room
    @PostMapping("/showroom")
    public ResponseEntity<?> createShowroom(@Valid @RequestBody CarShowroom showroom) {
        log.info("Create a new showroom: " + showroom.toString());
        CarShowroom newShowroom = showRoomService.createShowroom(showroom);
        return new ResponseEntity<>(newShowroom, HttpStatus.CREATED);
    }
    
}
