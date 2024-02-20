# Parking Automation Tool
## About 
This project simulates an automated parking lot management system. Features a CLI Tool with a set of commands to create, manage and retrieve information about the parking lot. 
Functionality:

+ Accommodates up to n cars with numbered slots (closest to entry first).
+ Issues tickets upon car entry, recording registration number, color, and assigned slot.
+ Marks slots available upon ticket return.
+ Provides information on:
   - All car registration numbers of a specific color.
   - Slot number of a car with a given registration number.
   - Slot numbers of all cars with a specific color.

## Steps for Installation

1. Clone the repo
   ```sh
    git clone https://github.com/CyberneTech/ParkingAutomation.git
   ```
2. Build the project using Maven:
* Navigate to the project directory in the terminal.
* Run the following Maven command to build the project and download all the necessary dependencies:
  ```sh
   mvn clean install
   ```
3. After the build is successful, start the Spring Boot application with the following command:
   ```sh
   mvn spring-boot:run
   ```
4. after `shell:>` prompt appears, enter `help` to get list of possible commands
5. use this guide and enter commads as listed to use the parking automation tool. Start with creating the parking lot using command:
```sh
   create_parking_lot <size_of_lot>
```
6. use park/leave/ other commands given below to perform desired action. 
7. finally, enter command `exit` to terminate the application.


### **Shell Commands available:**
>   + create_parking_lot <size_of_lot>: command to create a parking lot of given size
>   +  park <vehicle_registration_number> <color>: reserve a parking slot for vehicle details given
>   +  leave <parking_slot>: release given parking slot
>   +  status: get all parking slots status

>   +  registration_numbers_for_cars_with_color <vehicle_color>: get registration numbers of all cars with given color
>   +  parking_slot_for_registration_number <vehicle_registration_number>: gets the parking slot for given registration number
>   +  all_parking_slots_for_color <vehicle_color>: get all parking slots for having vehicles parking with given color

>   +  exit: to terminate the application

## Screenshots of prompt outputs
