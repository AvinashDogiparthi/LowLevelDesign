package C_ParkingLotDesign.ParkingObjects.ParkingSpot;

import C_ParkingLotDesign.Vehicle.VehicleTypeEnum;

// HAS-A relationship
public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(String id) {
        super(id, 20, VehicleTypeEnum.FOUR_WHEELER);
    }
}