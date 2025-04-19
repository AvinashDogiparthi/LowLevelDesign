package M_UberDesign.Management;

import M_UberDesign.Models.*;
import M_UberDesign.PaymentProcessor;
import Y_Utils.SystemDesignConstants;
import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideManagementService {
    public Map<Integer, Ride> rideList;
    public CabManagementService cabManagementService = CabManagementService.getInstance();

    private static RideManagementService instance = null;

    public static RideManagementService getInstance(){
        if(instance == null){
            instance = new RideManagementService();
            return instance;
        }

        return instance;
    }

    private RideManagementService() {
        this.rideList = new HashMap<>();
    }

    public Ride requestRide(Rider rider, int rideID, String tripName, String cityName, Location startLocation, Location endLocation){
        Cab nearestCab = cabManagementService.getNearestCab(cityName,startLocation);
        System.out.println("Nearest cab : "+nearestCab.getVehicleNumber()+" with driver : " + nearestCab.getDriver().getDrivername()+" of distance : "+nearestCab.currentLocation.calculateDistance(startLocation));
        int rideCost = computeRideCost(nearestCab.currentLocation.calculateDistance(startLocation));

        if(rider.getWalletCash() > rideCost){

            System.out.println("Rider wallet cash : "+rider.walletCash+ " is sufficient to book the ride with cost : "+rideCost);
            Ride ride = new RideBuilder()
                    .withRideID(rideID)
                    .withCab(nearestCab)
                    .withRideStatus(RideType.STARTED)
                    .withStartLocation(startLocation)
                    .withEndLocation(endLocation)
                    .withRideCode(rideCost)
                    .withRider(rider)
                    .withTripName(tripName)
                    .build();

            nearestCab.setAvailable(false);

            return ride;
        }

        return null;
    }

    public void endRide(Ride ride){
        if(ride.rideStatus == RideType.IN_PROGRESS || ride.rideStatus == RideType.STARTED){
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            paymentProcessor.removeMoneyFromUserWallet(ride.rider,ride.rideCost);
            ride.setRideStatus(RideType.COMPLETED);
            ride.getRider().addRide(ride);
            ride.getCab().getDriver().addRide(ride);
            ride.getCab().setAvailable(true);
            Cab cab = ride.getCab();
            cab.setCurrentLocation(ride.endDestination);
            cabManagementService.updateCab(cab.getCityName(),cab);
            rideList.remove(ride.getRideID());
        }
    }
    public void addRide(Ride ride){
        rideList.put(ride.getRideID(),ride);
    }

    public int computeRideCost(int distance){
        return distance*2;
    }

    public void removeRaid(int rideId){
        if(rideList.containsKey(rideId)){
            rideList.remove(rideId);
            System.out.println("Removed existing rideID");
        }
        System.out.println("No existing ride with rideID : "+rideId);
    }

}
