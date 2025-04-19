package M_UberDesign;

import M_UberDesign.Management.RideManagementService;
import M_UberDesign.Models.Location;
import M_UberDesign.Models.Ride;
import M_UberDesign.Models.Rider;
import Y_Utils.SystemDesignConstants;

public class UberDesignDemo {

    public static void main(String[] args) {
        RideManagementService rideManagementService = RideManagementService.getInstance();
        Rider rider = new Rider("Arjun",111,50);
        Location startLocation = new Location(0,0);
        Location endLocation = new Location(15,20);
        Ride ride = rideManagementService.requestRide(rider,123,"goaPotunnam", SystemDesignConstants.BANGALORE,startLocation,endLocation);
        System.out.println("Ride started");
        rideManagementService.endRide(ride);
        System.out.println("Ride ended");


        Ride ride2 = rideManagementService.requestRide(rider,124,"goaPotunnam", SystemDesignConstants.BANGALORE,startLocation,endLocation);
        System.out.println("Ride started");
        rideManagementService.endRide(ride2);
        System.out.println("Ride ended");
    }
}
