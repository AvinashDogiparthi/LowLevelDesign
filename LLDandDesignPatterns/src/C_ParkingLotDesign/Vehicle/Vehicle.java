package C_ParkingLotDesign.Vehicle;

public class Vehicle {
    String vehicleNumber;
    VehicleTypeEnum vehicleTypeEnum;

    public Vehicle(String vehicleNumber, VehicleTypeEnum vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleTypeEnum = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }
}
