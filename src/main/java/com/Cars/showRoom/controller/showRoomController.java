package com.Cars.showRoom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class showRoomController {
    private static final Logger log = LoggerFactory.getLogger(showRoomController.class);

    @GetMapping("/")
    public String helloShowRoom() {
        log.info("showRoomController controller called");
        return "Hello Elm!!";
    }
    
}
