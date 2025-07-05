package CA_ParkingLotDesign_V2.Parking;

import CA_ParkingLotDesign_V2.Vehicle.VehicleTypeEnum;

public class ParkingSpot {

    private int id;
    private VehicleTypeEnum vehicleTypeEnum;
    private boolean isOccupied;

    public ParkingSpot(int id, VehicleTypeEnum vehicleTypeEnum) {
        this.id = id;
        this.vehicleTypeEnum = vehicleTypeEnum;
        this.isOccupied = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
