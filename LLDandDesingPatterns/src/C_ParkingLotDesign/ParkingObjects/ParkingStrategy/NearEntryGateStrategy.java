package C_ParkingLotDesign.ParkingObjects.ParkingStrategy;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.ParkingSpot;
import C_ParkingLotDesign.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import C_ParkingLotDesign.Vehicle.Vehicle;

import java.util.List;

public class NearEntryGateStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle) {
        List<ParkingSpot> spots = manager.getParkingSpots();
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }
}
