package M_UberDesign.Models;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public String drivername;
    public int driverID;
    public List<Ride> ridesDone;

    public Driver(String drivername, int driverID) {
        this.drivername = drivername;
        this.driverID = driverID;
        ridesDone = new ArrayList<>();
    }


    public List<Ride> getRidesDone() {
        return ridesDone;
    }

    public void setRidesDone(List<Ride> ridesDone) {
        this.ridesDone = ridesDone;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public void addRide(Ride ride){
        ridesDone.add(ride);
    }
}
