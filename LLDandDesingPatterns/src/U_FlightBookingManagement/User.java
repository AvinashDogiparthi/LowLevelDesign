package U_FlightBookingManagement;

public class User {

    private int userID;
    private SeatCategoryEnum seatCategoryEnum;

    public User(int userID, SeatCategoryEnum seatCategoryEnum) {
        this.userID = userID;
        this.seatCategoryEnum = seatCategoryEnum;
    }

    public User(int userID) {
        this.userID = userID;
        this.seatCategoryEnum = SeatCategoryEnum.ECONOMY;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public SeatCategoryEnum getSeatCategoryEnum() {
        return seatCategoryEnum;
    }

    public void setSeatCategoryEnum(SeatCategoryEnum seatCategoryEnum) {
        this.seatCategoryEnum = seatCategoryEnum;
    }
}
