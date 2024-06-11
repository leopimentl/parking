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

    @Transactional
    public ParkingSpace parkVehicle(UUID parkingSpaceId, UUID vehicleId) {
        ParkingSpace parkingSpace = this.parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ParkingSpaceNotFoundException("Parking space not found"));

        Vehicle vehicle = this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));

        if (parkingSpace.isOccupied()) {
            throw new RuntimeException("Parking space is already occupied");
        }

        if (parkingSpace.getVehicleType() != vehicle.getType()) {
            throw new RuntimeException("Vehicle type is not compatible with parking space");
        }

        parkingSpace.setVehicle(vehicle);
        parkingSpace.setOccupied(true);

        vehicleRepository.updateParkingSpace(vehicle.getId(), parkingSpace);

        return this.parkingSpaceRepository.save(parkingSpace);
    }
}
