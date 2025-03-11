package C_ParkingLotDesign.ParkingObjects.ParkingSpotManager;

import C_ParkingLotDesign.ParkingObjects.ParkingSpot.ParkingSpot;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager<T extends ParkingSpot> {
    protected List<T> parkingSpots;

    public ParkingSpotManager() {
        this.parkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(T parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(T parkingSpot) {
        parkingSpots.remove(parkingSpot);
    }

    public List<T> getParkingSpots() {
        return parkingSpots;
    }
}
