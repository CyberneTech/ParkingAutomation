package io.greenstitch.systems.ParkingAutomation.entity;

import lombok.Getter;
import lombok.Setter;

/***
 * 
 * Vehicle -> Class for maintaining vehicle information {registrationNumber,
 * color}
 */
@Getter
@Setter
public class Vehicle {

    String registrationNumber;
    String color;

    public Vehicle(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

}
