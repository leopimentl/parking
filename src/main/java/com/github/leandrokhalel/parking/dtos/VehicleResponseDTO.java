package com.github.leandrokhalel.parking.dtos;

import com.github.leandrokhalel.parking.enums.VehicleType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record VehicleResponseDTO(
        UUID id,
        String plate,
        String brand,
        String color,
        String model,
        VehicleType type
) {
}
