package C_ParkingLotDesign.ParkingObjects.ParkingStrategy;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.ParkingSpot;
import C_ParkingLotDesign.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import C_ParkingLotDesign.ParkingObjects.ParkingStrategy.ParkingStrategy;
import C_ParkingLotDesign.Vehicle.Vehicle;

import java.util.List;

public class NearExitGateStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle) {
        List<ParkingSpot> spots = manager.getParkingSpots();
        for (int i = spots.size() - 1; i >= 0; i--) {
            if (spots.get(i).isEmpty()) {
                return spots.get(i);
            }
        }
        return null;
    }
}