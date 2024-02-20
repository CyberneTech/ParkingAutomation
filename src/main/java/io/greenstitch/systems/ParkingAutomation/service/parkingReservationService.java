package io.greenstitch.systems.ParkingAutomation.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greenstitch.systems.ParkingAutomation.entity.Parking;
import io.greenstitch.systems.ParkingAutomation.entity.Vehicle;
import io.greenstitch.systems.ParkingAutomation.entity.ParkingLot;
import io.greenstitch.systems.ParkingAutomation.utils.DisplayTable;

@Service
public class parkingReservationService {

    // Singleton instance of ParkingLot across parking services
    public ParkingLot parkingLot;

    parkingReservationService() {
        this.parkingLot = ParkingLot.getInstance();
    }

    // method to create a new parking lot of given size
    public String createParking(int lotSize) throws Exception {
        if (parkingLot.parkingLot != null) {
            throw new Exception("Parking lot already exists");
        }

        ParkingLot.createParkingLot();
        for (int i = 0; i < lotSize; i++) {
            parkingLot.parkingLot.add(new Parking(false, null));
        }
        return "Parking lot created successfully";
    }

    // method to park a vehicle in the closest available parking lot
    public String parkVehicle(String registrationNumber, String color) throws Exception {
        if (parkingLot.parkingLot == null) {
            throw new Exception("Parking lot does not exist");
        }
        for (Parking parking : parkingLot.parkingLot) {
            if (parking.isOccupied()) {
                continue;
            }
            parking.park(new Vehicle(registrationNumber, color));
            return "Vehicle Parked Successfully!!\n Allocated slot number: "
                    + (parkingLot.parkingLot.indexOf(parking) + 1);
        }
        throw new Exception("Sorry, parking lot is full");
    }

    // to release a parking slot when the Vehicle leaves the parking lot
    public String releaseParkingLot(int slotNumber) throws Exception {
        if (parkingLot.parkingLot == null) {
            throw new Exception("Parking lot does not exist");
        }
        if (slotNumber <= 0 || slotNumber > parkingLot.parkingLot.size()) {
            throw new Exception("Invalid slot number");
        }
        if (!parkingLot.parkingLot.get(slotNumber - 1).isOccupied()) {
            throw new Exception("Slot number " + slotNumber + " is already free");
        }
        parkingLot.parkingLot.get(slotNumber - 1).release();
        return "Slot number " + slotNumber + " is free now";
    }

    // to get all parking slots status
    public void getAllParkingStatus() throws Exception {
        if (parkingLot.parkingLot == null) {
            throw new Exception("Parking lot does not exist");
        }
        DisplayTable displayTable = new DisplayTable(20);
        displayTable.addHeader(Arrays.asList("Slot No.", "Registration Number", "Color"));

        for (Parking parking : parkingLot.parkingLot) {
            if (parking.isOccupied()) {
                displayTable.addRow(Arrays.asList(Integer.toString(parkingLot.parkingLot.indexOf(parking) + 1),
                        parking.getParkedVehicleDetails().getRegistrationNumber(),
                        parking.getParkedVehicleDetails().getColor()));
            }
        }
        displayTable.display();
    }

}
