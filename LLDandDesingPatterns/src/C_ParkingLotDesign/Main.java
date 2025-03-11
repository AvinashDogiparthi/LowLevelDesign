package C_ParkingLotDesign;

import C_ParkingLotDesign.ParkingObjects.ParkingLot;
import C_ParkingLotDesign.ParkingObjects.ParkingTicket;
import C_ParkingLotDesign.Vehicle.Vehicle;
import C_ParkingLotDesign.Vehicle.VehicleTypeEnum;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        Vehicle bike = new Vehicle("BIKE-123", VehicleTypeEnum.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-456", VehicleTypeEnum.FOUR_WHEELER);

        // Vehicles entering
        ParkingTicket bikeTicket = parkingLot.enterVehicle(bike);
        ParkingTicket carTicket = parkingLot.enterVehicle(car);

        // Vehicles exiting
        if (bikeTicket != null) parkingLot.exitVehicle(bikeTicket.getTicketId());
        if (carTicket != null) parkingLot.exitVehicle(carTicket.getTicketId());
    }
}
