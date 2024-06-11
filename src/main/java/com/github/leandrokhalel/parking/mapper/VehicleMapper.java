package com.github.leandrokhalel.parking.mapper;

import com.github.leandrokhalel.parking.dtos.CreateVehicleRequestDTO;
import com.github.leandrokhalel.parking.entities.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle map(CreateVehicleRequestDTO createVehicleRequestDTO) {
        return Vehicle.builder()
                .brand(createVehicleRequestDTO.brand())
                .color(createVehicleRequestDTO.color())
                .model(createVehicleRequestDTO.model())
                .plate(createVehicleRequestDTO.plate())
                .type(createVehicleRequestDTO.type())
                .build();
    }
}
