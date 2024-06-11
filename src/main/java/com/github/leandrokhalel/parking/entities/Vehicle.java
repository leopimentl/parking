package com.github.leandrokhalel.parking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.leandrokhalel.parking.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String plate;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private VehicleType type;

    @OneToOne
    @JsonIgnore
    private ParkingSpace parkingSpace;
}
