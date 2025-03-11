package C_ParkingLotDesign.ParkingObjects;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.FourWheelerSpot;
import C_ParkingLotDesign.ParkingObjects.ParkingSpot.TwoWheelerSpot;
import C_ParkingLotDesign.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import C_ParkingLotDesign.ParkingObjects.ParkingStrategy.EntryGate;
import C_ParkingLotDesign.ParkingObjects.ParkingStrategy.ExitGate;
import C_ParkingLotDesign.ParkingObjects.ParkingStrategy.NearEntryGateStrategy;
import C_ParkingLotDesign.ParkingObjects.ParkingStrategy.ParkingStrategy;
import C_ParkingLotDesign.Vehicle.Vehicle;
import C_ParkingLotDesign.Vehicle.VehicleTypeEnum;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private ParkingSpotManager parkingSpotManager;
    private EntryGate entryGate;
    private ExitGate exitGate;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot() {
        this.parkingSpotManager = new ParkingSpotManager();
        this.activeTickets = new HashMap<>();

        // 🟢 ADDING INITIAL PARKING SPOTS
        for (int i = 1; i <= 5; i++) { // Adding 5 spots for each type
            parkingSpotManager.addParkingSpot(new TwoWheelerSpot("TW-" + i));
            parkingSpotManager.addParkingSpot(new FourWheelerSpot("FW-" + i));
        }

        ParkingStrategy strategy = new NearEntryGateStrategy();
        this.entryGate = new EntryGate("Gate-1", parkingSpotManager, strategy);
        this.exitGate = new ExitGate("Gate-1", activeTickets);
    }

    public ParkingTicket enterVehicle(Vehicle vehicle) {
        ParkingTicket ticket = entryGate.parkVehicle(vehicle);
        if (ticket != null) {
            activeTickets.put(ticket.getTicketId(), ticket);
        }
        return ticket;
    }

    public void exitVehicle(String ticketId) {
        exitGate.exitVehicle(ticketId);
    }
}
