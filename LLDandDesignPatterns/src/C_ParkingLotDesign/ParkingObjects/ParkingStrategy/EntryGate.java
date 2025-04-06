package C_ParkingLotDesign.ParkingObjects.ParkingStrategy;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.ParkingSpot;
import C_ParkingLotDesign.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import C_ParkingLotDesign.ParkingObjects.ParkingStrategy.ParkingStrategy;
import C_ParkingLotDesign.ParkingObjects.ParkingTicket;
import C_ParkingLotDesign.Vehicle.Vehicle;

public class EntryGate {
    private String gateId;
    private ParkingSpotManager parkingSpotManager;
    private ParkingStrategy parkingStrategy;

    public EntryGate(String gateId, ParkingSpotManager parkingSpotManager, ParkingStrategy parkingStrategy) {
        this.gateId = gateId;
        this.parkingSpotManager = parkingSpotManager;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingStrategy.findParkingSpot(parkingSpotManager, vehicle);
        if (spot == null) {
            System.out.println("No spot available for " + vehicle.getVehicleNumber());
            return null;
        }

        spot.parkVehicle(vehicle);
        String ticketId = "TICKET-" + System.currentTimeMillis();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot);
        System.out.println("Vehicle parked with ticket: " + ticketId);
        return ticket;
    }
}
