package CA_ParkingLotDesign_V2.Parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {

    int parkingFloor;
    Map<Integer, ParkingSpot> parkingSpotList;

    public ParkingFloor(int parkingFloor){
        this.parkingFloor = parkingFloor;
        this.parkingSpotList = new HashMap<>();
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(int parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public Map<Integer,ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(Map<Integer,ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpotList.put(parkingSpot.getId(),parkingSpot);
    }

    public void removeParkingSpot(int parkingSpotID){
        this.parkingSpotList.remove(parkingSpotID);
    }
}
