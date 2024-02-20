package io.greenstitch.systems.ParkingAutomation.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/***
 * Parking Lot -> Singleton Class for maintaining single instance of ParkingLot
 * across parking services
 * 
 * Storing list of parking slots
 */

@Getter
@Setter
public class ParkingLot {
    private static final ParkingLot instance;

    ParkingLot() {
    }

    static {
        instance = new ParkingLot();
    }

    public List<Parking> parkingLot;

    public static ParkingLot getInstance() {
        return instance;
    }

    public static List<Parking> createParkingLot() {
        instance.parkingLot = new ArrayList<Parking>();
        return instance.parkingLot;
    }
}