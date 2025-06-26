package U_FlightBookingManagement.Seat;

import U_FlightBookingManagement.User.User;

public class Seat {

    private int seatID;
    private SeatCategoryEnum seatCategoryEnum;
    private int seatPrice;
    private boolean isBooked;
    private User seatOwner;

    public Seat(int seatID, SeatCategoryEnum seatCategoryEnum, int seatPrice) {
        this.seatID = seatID;
        this.seatCategoryEnum = seatCategoryEnum;
        this.seatPrice = seatPrice;
        this.isBooked = false;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public SeatCategoryEnum getSeatCategoryEnum() {
        return seatCategoryEnum;
    }

    public void setSeatCategoryEnum(SeatCategoryEnum seatCategoryEnum) {
        this.seatCategoryEnum = seatCategoryEnum;
    }

    public int getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(int seatPrice) {
        this.seatPrice = seatPrice;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public User getSeatOwner() {
        return seatOwner;
    }

    public void setSeatOwner(User seatOwner) {
        this.seatOwner = seatOwner;
    }
}
