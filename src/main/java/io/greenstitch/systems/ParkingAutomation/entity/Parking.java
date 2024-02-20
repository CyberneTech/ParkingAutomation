package io.greenstitch.systems.ParkingAutomation.entity;

import lombok.Getter;
import lombok.Setter;

/***
 * Entity strcture for Parking {parkingStatus, parkedVehicleDetails}
 * Storing detail of parked vehicle
 * Storing availibity of parking slot
 * methods to set/ update the current parking status, parked vehicle details
 */
@Getter
@Setter
public class Parking {
    boolean parkingStatus;

    Vehicle parkedVehicleDetails;

    public Parking(boolean parkingStatus, Vehicle parkedVehicleDetails) {
        this.parkingStatus = parkingStatus;
        this.parkedVehicleDetails = parkedVehicleDetails;
    }

    public boolean isOccupied() {
        return parkingStatus;
    }

    public void park(Vehicle vehicle) {
        this.parkingStatus = true;
        this.parkedVehicleDetails = vehicle;
    }

    public void release() {
        this.parkingStatus = false;
        this.parkedVehicleDetails = null;
    }

}
