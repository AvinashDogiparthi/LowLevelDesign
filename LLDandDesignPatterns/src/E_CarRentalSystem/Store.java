package E_CarRentalSystem;

import E_CarRentalSystem.Product.Vehicle;
import E_CarRentalSystem.Reservation.Reservation;

import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location storeLocation;
    List<Reservation> reservationList;

    public List<Vehicle> getVehicles(){
        return vehicleInventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles){
        this.vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReservation(user,vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID){
        return true;
    }
}
