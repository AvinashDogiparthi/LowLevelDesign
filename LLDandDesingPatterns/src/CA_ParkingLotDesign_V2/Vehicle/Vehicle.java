package CA_ParkingLotDesign_V2.Vehicle;

public class Vehicle {

    private int vehicleID;
    private VehicleTypeEnum vehicleTypeEnum;

    public Vehicle(int vehicleID, VehicleTypeEnum vehicleTypeEnum){
        this.vehicleID = vehicleID;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }
}
