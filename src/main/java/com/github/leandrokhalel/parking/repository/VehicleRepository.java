package com.github.leandrokhalel.parking.repository;

import com.github.leandrokhalel.parking.entities.ParkingSpace;
import com.github.leandrokhalel.parking.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    @Modifying
    @Query("UPDATE Vehicle SET parkingSpace=(:parkingSpace) WHERE id=(:id)")
    void updateParkingSpace(@Param("id") UUID id, @Param("parkingSpace") ParkingSpace parkingSpace);

    boolean existsByPlate(String plate);
}
