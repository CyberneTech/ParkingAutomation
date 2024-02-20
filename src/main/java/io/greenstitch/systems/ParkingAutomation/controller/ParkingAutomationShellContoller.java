package io.greenstitch.systems.ParkingAutomation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import io.greenstitch.systems.ParkingAutomation.service.parkingReservationService;
import io.greenstitch.systems.ParkingAutomation.service.parkingVehicleInformationService;

@ShellComponent
public class ParkingAutomationShellContoller {

    @Autowired
    public parkingReservationService parkingService;

    @Autowired
    public parkingVehicleInformationService parkingInformationService;

    @ShellMethod(key = "create_parking_lot", value = "command to create a parking lot of given size")
    public void createParking(@ShellOption(defaultValue = "10") int lotSize) {
        try {
            System.out.println(parkingService.createParking(lotSize));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod(key = "park", value = "reserve a parking slot for vehicle details given")
    public void parkVehicle(@ShellOption String VehicleDetails) {
        String registrationNumber = VehicleDetails.split(",")[0];
        String color = VehicleDetails.split(",")[1];
        try {
            System.out.println(parkingService.parkVehicle(registrationNumber, color));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @ShellMethod(key = "leave", value = "release given parking slot")
    public void leave(@ShellOption int slotNumber) {
        try {
            System.out.println(parkingService.releaseParkingLot(slotNumber));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod(key = "status", value = "get all parking slots status")
    public void getAllParkingStatus() {
        try {
            parkingService.getAllParkingStatus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod(key = "parking_slot_for_registration_number", value = "gets the parking slot for given registration number")
    public void getVehicleSlot(@ShellOption String registrationNumber) {
        try {
            System.out.println(parkingInformationService.getParkingSlot(registrationNumber));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod(key = "registration_numbers_for_cars_with_color", value = "get registration numbers of all cars with given color")
    public void getVehicleWithColor(@ShellOption String color) {
        try {
            parkingInformationService.getVehiclesWithColor(color);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @ShellMethod(key = "all_parking_slots_for_color", value = "get all parking slots for having vehicles parking with given color")
    public void getParkingSlotsForVehicleColor(@ShellOption String color) {
        try {
            parkingInformationService.getParkingSlotsForVehicleColor(color);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod(key = "exit", value = "")
    public void exitApplication() {
        System.exit(0);
    }
}