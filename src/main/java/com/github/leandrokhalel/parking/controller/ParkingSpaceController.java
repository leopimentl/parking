package com.github.leandrokhalel.parking.controller;

import com.github.leandrokhalel.parking.dtos.ParkVehicleRequestDTO;
import com.github.leandrokhalel.parking.entities.ParkingSpace;
import com.github.leandrokhalel.parking.service.ParkingSpaceService;
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
@RequestMapping("/parking-spaces")
public class ParkingSpaceController {

    private ParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @PostMapping("/")
    public ResponseEntity<ParkingSpace> save(@Valid @RequestBody ParkingSpace parkingSpace) {
        parkingSpace = this.parkingSpaceService.save(parkingSpace);
        URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(parkingSpace.getId())
                .toUri();
        return ResponseEntity.created(uriLocation).body(parkingSpace);
    }
}
