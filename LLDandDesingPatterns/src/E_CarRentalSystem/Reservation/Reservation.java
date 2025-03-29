package E_CarRentalSystem.Reservation;

import E_CarRentalSystem.Location;
import E_CarRentalSystem.Product.Vehicle;
import E_CarRentalSystem.User;

import java.util.Date;
import java.util.Random;

public class Reservation {

    int reservationID;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTill;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;
    private Random random;

    public int createReservation(User user, Vehicle vehicle){
        reservationID = random.nextInt();;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationID;
    }
}
