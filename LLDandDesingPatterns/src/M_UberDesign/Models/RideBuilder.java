package M_UberDesign.Models;

public class RideBuilder{
    public int rideID;
    public String tripName;
    public Rider rider;
    public Cab cab;
    public Location startDestination;
    public Location endDestination;
    public int rideCost;
    public RideType rideStatus;

    public RideBuilder withRideID(int rideID){
        this.rideID = rideID;
        return this;
    }

    public RideBuilder withTripName(String tripName){
        this.tripName = tripName;
        return this;
    }

    public RideBuilder withRider(Rider rider){
        this.rider = rider;
        return this;
    }

    public RideBuilder withCab(Cab cab) {
        this.cab = cab;
        return this;
    }

    public RideBuilder withStartLocation(Location location){
        this.startDestination = location;
        return this;
    }

    public RideBuilder withEndLocation(Location location){
        this.endDestination = location;
        return this;
    }

    public RideBuilder withRideCode(int rideCost){
        this.rideCost = rideCost;
        return this;
    }

    public RideBuilder withRideStatus(RideType rideStatus){
        this.rideStatus = rideStatus;
        return this;
    }

    public Ride build(){
        return new Ride(this);
    }
}
