package com.Cars.showRoom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Cars.showRoom.entity.Car;
import com.Cars.showRoom.DTO.CarShowroomDetailsDTO;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT new com.Cars.showRoom.DTO.CarShowroomDetailsDTO(" +
       "c.vin, c.maker, c.model, c.modelYear, c.price, cs.contactNumber, cs.name) " +
       "FROM Car c JOIN c.carShowroom cs " +
       "WHERE (:vin IS NULL OR c.vin LIKE :vin) " +
       "AND (:id IS NULL OR c.carShowroom.id = :id)"+
       "AND (:maker IS NULL OR c.maker LIKE :maker) " +
       "AND (:model IS NULL OR c.model LIKE :model) " +
       "AND (:modelYear IS NULL OR c.modelYear = :modelYear) " +
       "AND (:showroomName IS NULL OR cs.name LIKE :showroomName) " +
       "AND (:contactNumber IS NULL OR cs.contactNumber LIKE :contactNumber)")
Page<CarShowroomDetailsDTO> findAllWithShowroomDetails(
    Pageable pageable,
    @Param("vin") String vin,
    @Param("id") String id,
    @Param("maker") String maker,
    @Param("model") String model,
    @Param("modelYear") String modelYear,
    @Param("showroomName") String showroomName,
    @Param("contactNumber") String contactNumber);

}


