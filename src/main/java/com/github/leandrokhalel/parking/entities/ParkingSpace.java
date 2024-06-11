package com.github.leandrokhalel.parking.entities;

import com.github.leandrokhalel.parking.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private VehicleType vehicleType;

    @Column
    private boolean isOccupied;

    @OneToOne
    private Vehicle vehicle;
}
