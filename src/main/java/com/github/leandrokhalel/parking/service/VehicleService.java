package com.github.leandrokhalel.parking.service;

import com.github.leandrokhalel.parking.entities.Vehicle;
import com.github.leandrokhalel.parking.repository.VehicleRepository;
import com.github.leandrokhalel.parking.dtos.CreateVehicleRequestDTO;
import com.github.leandrokhalel.parking.dtos.VehicleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleResponseDTO save(CreateVehicleRequestDTO createVehicleRequestDTO) {
        Vehicle vehicle = Vehicle.builder()
                .brand(createVehicleRequestDTO.brand())
                .color(createVehicleRequestDTO.color())
                .model(createVehicleRequestDTO.model())
                .plate(createVehicleRequestDTO.plate())
                .type(createVehicleRequestDTO.type())
                .build();

        this.vehicleRepository.save(vehicle);

        return VehicleResponseDTO.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .color(vehicle.getColor())
                .model(vehicle.getModel())
                .plate(vehicle.getPlate())
                .type(vehicle.getType())
                .build();
    }
}
