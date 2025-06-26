package U_FlightBookingManagement.NotificationStrategy.utils;

import U_FlightBookingManagement.Seat.SeatCategoryEnum;

public class NotificationDetails {

    private int userID;
    private boolean bookingStatus;
    private boolean cancellationStatus;
    private int seatID;
    private SeatCategoryEnum seatCategoryEnum;


    public NotificationDetails(NotificationBuilder notificationBuilder){
        this.userID = notificationBuilder.userID;
        this.bookingStatus = notificationBuilder.bookingStatus;
        this.cancellationStatus = notificationBuilder.cancellationStatus;
        this.seatID = notificationBuilder.seatID;
        this.seatCategoryEnum = notificationBuilder.seatCategoryEnum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public boolean isCancellationStatus() {
        return cancellationStatus;
    }

    public void setCancellationStatus(boolean cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
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
}
