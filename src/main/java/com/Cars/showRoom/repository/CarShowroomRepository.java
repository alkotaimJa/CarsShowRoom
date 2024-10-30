package com.Cars.showRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cars.showRoom.entity.CarShowroom;

@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroom, Long> {
}

    

