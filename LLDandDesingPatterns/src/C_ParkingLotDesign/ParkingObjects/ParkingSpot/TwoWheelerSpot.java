package C_ParkingLotDesign.ParkingObjects.ParkingSpot;

import C_ParkingLotDesign.Vehicle.VehicleTypeEnum;

// HAS-A relationship
public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(String id) {
        super(id, 10, VehicleTypeEnum.TWO_WHEELER);
    }
}
