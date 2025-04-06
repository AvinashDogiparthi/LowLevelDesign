package C_ParkingLotDesign.ParkingObjects.ParkingStrategy;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.ParkingSpot;
import C_ParkingLotDesign.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import C_ParkingLotDesign.Vehicle.Vehicle;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle);
}
