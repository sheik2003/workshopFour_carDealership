package com.ps;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> vehiclesByPrice(double min, double max){

    ArrayList<Vehicle> filteredByPriceVehicles = new ArrayList<>();

    for (Vehicle vehicle : inventory){
        double vehiclePrice = vehicle.getPrice();

        if (vehiclePrice >= min && vehiclePrice <= max){
            filteredByPriceVehicles.add(vehicle);
        }

    }
        return filteredByPriceVehicles ;
    }

    public ArrayList<Vehicle> vehiclesByMakeModel(String make, String model){

        ArrayList<Vehicle> filteredVehiclesByModel = new ArrayList<>();

        for (Vehicle vehicle : inventory){

            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filteredVehiclesByModel.add(vehicle);
            }

        }
        return filteredVehiclesByModel ;
    }

    public ArrayList<Vehicle> vehiclesByYear(int min, int max){
        ArrayList<Vehicle> filteredVehiclesByYear = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                filteredVehiclesByYear.add(vehicle);
            }
        }
        return filteredVehiclesByYear ;
    }

    public ArrayList<Vehicle> vehiclesByColor(String color){

        ArrayList<Vehicle> filteredByColor = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                filteredByColor.add(vehicle);
            }
        }
        return filteredByColor ;
    }

    public ArrayList<Vehicle> vehiclesByMilage(int min , int max) {

        ArrayList<Vehicle> filteredByMileage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            double vehicleMileage = vehicle.getOdometer();

            if (vehicleMileage >= min && vehicleMileage <= max) {
                filteredByMileage.add(vehicle);
            }


        }
        return filteredByMileage;

    }


    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;

}
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    //TODO : make helper function for printing the loop part


// TODO
//    get VehiclesByMileage(min, max) : List<Vehicle>
//    get VehiclesByType(vehicleType) : List<Vehicle>
//    remove Vehicle(vehicle)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}