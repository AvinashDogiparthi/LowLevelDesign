package M_UberDesign.Models;

public class CabBuilder{
    public String vehicleNumber;
    public Driver driver;
    public Location currentLocation;
    public boolean isAvailable;
    public String cityName;

    public CabBuilder withVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public CabBuilder withCityName(String cityName){
        this.cityName = cityName;
        return this;
    }

    public CabBuilder withIsAvailable(boolean flag){
        this.isAvailable = flag;
        return this;
    }

    public CabBuilder withDriver(Driver driver){
        this.driver = driver;
        return this;
    }

    public CabBuilder withLocation(Location location){
        this.currentLocation = location;
        return this;
    }

    public Cab build(){
        return new Cab(this);
    }
}
