package com.Cars.showRoom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Cars.showRoom.entity.CarShowroom;
import com.Cars.showRoom.projection.CarShowroomProjection;

@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroom, Long> {

    @Query("SELECT cs FROM CarShowroom cs WHERE cs.deleted = false")
    Page<CarShowroomProjection> findAllShowrooms(Pageable pageable);

    @Query("SELECT cs FROM CarShowroom cs WHERE cs.commercial_registration_number = :commercial_registration_number")
    CarShowroom findCarShowroomByCommercialRegistrationNumber(String commercial_registration_number);

    @Query("SELECT cs FROM CarShowroom cs WHERE cs.deleted = false AND cs.commercial_registration_number = :commercial_registration_number")
    CarShowroom findCarShowroomByCommercialRegistrationNumberAndNotDeleted(String commercial_registration_number);

    @Query("SELECT cs FROM CarShowroom cs WHERE cs.id = :showroomId AND cs.deleted = false")
    CarShowroom findByIdAndDeleted(Long showroomId);

}

    

