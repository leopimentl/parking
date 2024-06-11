package com.github.leandrokhalel.parking.service;

import com.github.leandrokhalel.parking.repository.ParkingSpaceRepository;
import com.github.leandrokhalel.parking.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingManagerService {

    private ParkingSpaceRepository parkingSpaceRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public ParkingManagerService(ParkingSpaceRepository parkingSpaceRepository, VehicleRepository vehicleRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleRepository = vehicleRepository;
    }

}
