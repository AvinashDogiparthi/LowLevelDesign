package M_UberDesign.Models;

import java.util.ArrayList;
import java.util.List;

public class Rider {
    public String riderName;
    public int riderId;
    public List<Ride> ridesDone;
    public int walletCash;

    public Rider(String riderName, int riderId, int walletCash) {
        this.riderName = riderName;
        this.riderId = riderId;
        this.walletCash = walletCash;
        this.ridesDone = new ArrayList<>();
    }

    public List<Ride> getRidesDone() {
        return ridesDone;
    }

    public void setRidesDone(List<Ride> ridesDone) {
        this.ridesDone = ridesDone;
    }

    public void addRide(Ride ride){
        ridesDone.add(ride);
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public int getWalletCash() {
        return walletCash;
    }

    public void setWalletCash(int walletCash) {
        this.walletCash = walletCash;
    }

    public void reduceWalletCash(int cashToBeRemoved){
        walletCash = walletCash-cashToBeRemoved;
    }
}
