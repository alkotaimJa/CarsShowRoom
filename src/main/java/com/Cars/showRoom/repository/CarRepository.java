package com.Cars.showRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cars.showRoom.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}

