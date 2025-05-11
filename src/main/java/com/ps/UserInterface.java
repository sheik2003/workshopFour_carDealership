package com.ps;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public UserInterface() {
        init();
    }

    public void display() {

        System.out.println("Welcome to the dealership program");

        int mainMenuCommand;

        do {
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.print("Command: ");
            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found, try again");
            }
        } while (mainMenuCommand != 0);
    }


    private void processGetByPriceRequest() {
        System.out.println("--------Display vehicles by price--------");
        System.out.print("Min: ");
        double min = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Max: ");
        double max = scanner.nextDouble();
        scanner.nextLine();


        ArrayList<Vehicle> filteredByPriceVehicles = dealership.vehiclesByPrice(min, max);

        displayVehicles(filteredByPriceVehicles);
    }

    private void processGetByMakeModelRequest() {

        System.out.println("--------Display vehicles by make model--------");

        //for spillover
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> filteredVehiclesByModel = dealership.vehiclesByMakeModel(make, model);
        displayVehicles(filteredVehiclesByModel);

    }

    private void processGetByYearRequest() {
        System.out.println("--------Display vehicles by year--------");
        System.out.print("Min: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Max: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> filteredByYear = dealership.vehiclesByYear(min, max);

        displayVehicles(filteredByYear);


    }

    private void processGetByColorRequest() {


        System.out.println("--------Display vehicles by Color--------");

        System.out.print("Color: ");
        scanner.nextLine();
        String color = scanner.nextLine();

        ArrayList<Vehicle> filteredByColor = dealership.vehiclesByColor(color);

        displayVehicles(filteredByColor);
    }

    private void processGetByMileageRequest() {

        System.out.println("--------Display vehicles by mileage--------");
        System.out.print("Min: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Max: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> filteredByMileage = dealership.vehiclesByMilage(min, max);
        displayVehicles(filteredByMileage);

    }

    private void processGetByVehicleTypeRequest() {

        System.out.println("--------Display vehicles by Vehicle Type--------");

        System.out.print("VehicleType: ");
        scanner.nextLine();
        String vehicleType = scanner.nextLine();

        ArrayList<Vehicle> filteredByVehicleType = dealership.VehicleType(vehicleType);

        displayVehicles(filteredByVehicleType);

    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("---------Printing all vehicles-----------");
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {

        scanner.nextLine();

        System.out.println("Enter Vehicle Vin: ");
        int vin = scanner.nextInt();

        System.out.println("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter make : ");
        String make = scanner.nextLine();

        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter mileage: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Vehicle added and saved.");

    }

    private void processRemoveVehicleRequest() {

        System.out.println("Enter Vin of car to remove: ");
        int vin = scanner.nextInt();
        dealership.removeVehicle(vin);
        DealershipFileManager.saveDealership(dealership);
    }

    public static void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.printf("%-6s %-6s %-10s %-12s %-10s %-10s %-10s %-10s\n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Miles", "Price");

        System.out.println("-------------------------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-6d %-6d %-10s %-12s %-10s %-10s %-10d $%-9.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());
        }
    }

}