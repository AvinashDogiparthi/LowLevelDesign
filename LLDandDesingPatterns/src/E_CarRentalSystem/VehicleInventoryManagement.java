package E_CarRentalSystem;

import E_CarRentalSystem.Product.Vehicle;

import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;

    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
}
