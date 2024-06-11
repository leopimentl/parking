package com.github.leandrokhalel.parking.service;

import com.github.leandrokhalel.parking.entities.ParkingSpace;
import com.github.leandrokhalel.parking.entities.Vehicle;
import com.github.leandrokhalel.parking.repository.ParkingSpaceRepository;
import com.github.leandrokhalel.parking.repository.VehicleRepository;
import com.github.leandrokhalel.parking.service.exceptions.ParkingSpaceNotFoundException;
import com.github.leandrokhalel.parking.service.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ParkingSpaceService {

    private ParkingSpaceRepository parkingSpaceRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, VehicleRepository vehicleRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public ParkingSpace save(ParkingSpace parkingSpace) {
        return this.parkingSpaceRepository.save(parkingSpace);
    }
}
