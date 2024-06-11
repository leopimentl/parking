package com.github.leandrokhalel.parking.controller;

import com.github.leandrokhalel.parking.dtos.CreateVehicleRequestDTO;
import com.github.leandrokhalel.parking.dtos.VehicleResponseDTO;
import com.github.leandrokhalel.parking.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity<VehicleResponseDTO> save(@Valid @RequestBody CreateVehicleRequestDTO createVehicleRequestDTO) {
        VehicleResponseDTO vehicleResponseDTO = this.vehicleService.save(createVehicleRequestDTO);

        URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vehicleResponseDTO.id())
                .toUri();

        return ResponseEntity.created(uriLocation).body(vehicleResponseDTO);
    }
}
