package com.github.leandrokhalel.parking.repository;

import com.github.leandrokhalel.parking.entities.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, UUID> {
}
