package M_UberDesign.Models;

public class Cab {

    public String vehicleNumber;
    public Driver driver;
    public Location currentLocation;
    public boolean isAvailable;
    public String cityName;

    public Cab(CabBuilder cabBuilder) {
        this.vehicleNumber = cabBuilder.vehicleNumber;
        this.driver = cabBuilder.driver;
        this.currentLocation = cabBuilder.currentLocation;
        this.isAvailable = cabBuilder.isAvailable;
        this.cityName = cabBuilder.cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setAvailable(boolean available){
        this.isAvailable = available;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
