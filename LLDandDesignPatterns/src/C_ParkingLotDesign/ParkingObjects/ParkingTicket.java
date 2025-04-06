package C_ParkingLotDesign.ParkingObjects;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.ParkingSpot;
import C_ParkingLotDesign.Vehicle.Vehicle;
import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public void printTicket() {
        System.out.println("🎟 Parking Ticket:");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Vehicle Type: " + vehicle.getVehicleTypeEnum());
        System.out.println("Spot ID: " + parkingSpot.getId());
        System.out.println("Entry Time: " + entryTime);
    }

    public int calculateFare(LocalDateTime exitTime) {
        long hours = java.time.Duration.between(entryTime, exitTime).toHours();
        return (int) Math.max(1, hours) * parkingSpot.getPrice();
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
