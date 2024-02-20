package io.greenstitch.systems.ParkingAutomation.service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.greenstitch.systems.ParkingAutomation.entity.Parking;
import io.greenstitch.systems.ParkingAutomation.entity.ParkingLot;

@Service
public class parkingVehicleInformationService {

    // Singleton instance of ParkingLot across parking services
    public ParkingLot parkingLot;

    parkingVehicleInformationService() {
        this.parkingLot = ParkingLot.getInstance();
    }

    // method to get the pakring slot of rgiven registration number
    public String getParkingSlot(String registrationNumber) throws Exception {
        if (parkingLot.parkingLot == null) {
            throw new Exception("Parking lot does not exist");
        }
        for (Parking parking : parkingLot.parkingLot) {
            if (parking.isOccupied()) {
                if (parking.getParkedVehicleDetails().getRegistrationNumber().equals(registrationNumber)) {
                    return "Allocated slot number: " + (parkingLot.parkingLot.indexOf(parking) + 1);
                }
            }
        }
        return "No Parking information found for vehicle with registration number: " + registrationNumber;
    }

    // method to get the registration number of the vehicles of given color
    public void getVehiclesWithColor(String color) throws Exception {
        if (parkingLot.parkingLot == null) {
            throw new Exception("Parking lot does not exist");
        }
        boolean carsFound = false;
        for (Parking parking : parkingLot.parkingLot) {
            if (parking.isOccupied()) {
                if (parking.getParkedVehicleDetails().getColor().equals(color)) {
                    carsFound = true;
                    System.out.println(parking.getParkedVehicleDetails().getRegistrationNumber());
                }
            }
        }

        if (!carsFound)
            throw new Exception("No Vehicle found with color: " + color);
    }

    // method to get the parking slots for the vehicles of given color
    public void getParkingSlotsForVehicleColor(String color) throws Exception {
        if (parkingLot.parkingLot == null) {
            throw new Exception("Parking lot does not exist");
        }

        boolean slotFound = false;
        for (Parking parking : parkingLot.parkingLot) {
            if (parking.isOccupied()) {
                if (parking.getParkedVehicleDetails().getColor().equals(color)) {
                    slotFound = true;
                    System.out.println("Allocated slot number: " + (parkingLot.parkingLot.indexOf(parking) + 1));
                }
            }
        }
        if (!slotFound)
            throw new Exception("No Vehicle found with color: " + color);
    }

}
