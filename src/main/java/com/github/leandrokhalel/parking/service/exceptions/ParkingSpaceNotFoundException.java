package com.github.leandrokhalel.parking.service.exceptions;

public class ParkingSpaceNotFoundException extends RuntimeException {
    public ParkingSpaceNotFoundException(String message) {
        super(message);
    }
}
