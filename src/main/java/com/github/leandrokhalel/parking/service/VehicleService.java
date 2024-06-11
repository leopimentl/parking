package com.github.leandrokhalel.parking.service;

import com.github.leandrokhalel.parking.mapper.VehicleMapper;
import com.github.leandrokhalel.parking.entities.Vehicle;
import com.github.leandrokhalel.parking.repository.VehicleRepository;
import com.github.leandrokhalel.parking.dtos.CreateVehicleRequestDTO;
import com.github.leandrokhalel.parking.dtos.VehicleResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    private VehicleMapper vehicleMapper;

    public VehicleService(VehicleMapper vehicleMapper, VehicleRepository vehicleRepository) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleResponseDTO save(CreateVehicleRequestDTO createVehicleRequestDTO) {
        boolean plateAlreadyRegistered = vehicleRepository.existsByPlate(createVehicleRequestDTO.plate());
        if (plateAlreadyRegistered) {
            throw new RuntimeException("Plate already registered");
        }

        Vehicle vehicle = vehicleMapper.map(createVehicleRequestDTO);
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
