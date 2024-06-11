package com.github.leandrokhalel.parking.dtos;

import com.github.leandrokhalel.parking.enums.VehicleType;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record CreateVehicleRequestDTO(

        @Pattern(
                regexp = "^[A-Za-z]{3}[0-9][A-Za-z0-9][0-9]{2}$",
                message = "Plate must follow the pattern ABC1D23"
        )
        String plate,

        String brand,
        String model,
        String color,
        VehicleType type
) {

}
