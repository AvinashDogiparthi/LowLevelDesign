package U_FlightBookingManagement.NotificationStrategy;

import U_FlightBookingManagement.SeatCategoryEnum;

public class NotificationBuilder {

    public int userID;
    public boolean bookingStatus;
    public boolean cancellationStatus;
    public int seatID;
    public SeatCategoryEnum seatCategoryEnum;


    public NotificationBuilder withUserID(int userID){
        this.userID = userID;
        return this;
    }

    public NotificationBuilder withBookingStatus(boolean bookingStatus){
        this.bookingStatus = bookingStatus;
        return this;
    }

    public NotificationBuilder withCancellationStatus(boolean cancellationStatus){
        this.cancellationStatus = cancellationStatus;
        return this;
    }

    public NotificationBuilder withSeatID(int seatID){
        this.seatID = seatID;
        return this;
    }

    public NotificationBuilder withSeatCategoryEnum(SeatCategoryEnum seatCategoryEnum){
        this.seatCategoryEnum = seatCategoryEnum;
        return this;
    }

    public NotificationDetails build(){
        return new NotificationDetails(this);
    }
}
