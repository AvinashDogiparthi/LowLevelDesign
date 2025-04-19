package M_UberDesign.Models;

public class Ride {

    public int rideID;
    public String tripName;
    public Rider rider;
    public Cab cab;
    public Location startDestination;
    public Location endDestination;
    public int rideCost;
    public RideType rideStatus;


    public Ride(RideBuilder rideBuilder) {
        this.rideID = rideBuilder.rideID;
        this.tripName = rideBuilder.tripName;
        this.rider = rideBuilder.rider;
        this.cab = rideBuilder.cab;
        this.startDestination = rideBuilder.startDestination;
        this.endDestination = rideBuilder.endDestination;
        this.rideCost = rideBuilder.rideCost;
        this.rideStatus = rideBuilder.rideStatus;
    }

    public RideType getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideType rideStatus) {
        this.rideStatus = rideStatus;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Location getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(Location startDestination) {
        this.startDestination = startDestination;
    }

    public Location getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(Location endDestination) {
        this.endDestination = endDestination;
    }

    public int getRideCost() {
        return rideCost;
    }

    public void setRideCost(int rideCost) {
        this.rideCost = rideCost;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }
}
