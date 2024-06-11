package com.github.leandrokhalel.parking.dtos;

import java.util.UUID;

public record ParkVehicleRequestDTO(

        UUID parkingSpaceId,
        UUID vehicleId
) {
}
