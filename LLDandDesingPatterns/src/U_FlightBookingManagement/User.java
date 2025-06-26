package U_FlightBookingManagement;

import U_FlightBookingManagement.NotificationStrategy.utils.NotificationStrategyEnum;

public class User {

    private int userID;
    private SeatCategoryEnum seatCategoryEnum;
    private int walletMoney;
    private NotificationStrategyEnum notificationStrategyEnum;

    public User(int userID, SeatCategoryEnum seatCategoryEnum) {
        this.userID = userID;
        this.seatCategoryEnum = seatCategoryEnum;
        this.walletMoney = 0;
        this.notificationStrategyEnum = NotificationStrategyEnum.SMS;
    }

    public User(int userID, SeatCategoryEnum seatCategoryEnum, NotificationStrategyEnum notificationStrategyEnum) {
        this.userID = userID;
        this.seatCategoryEnum = seatCategoryEnum;
        this.walletMoney = 0;
        this.notificationStrategyEnum = notificationStrategyEnum;
    }

    public User(int userID, SeatCategoryEnum seatCategoryEnum, int walletMoney) {
        this.userID = userID;
        this.seatCategoryEnum = seatCategoryEnum;
        this.walletMoney = walletMoney;
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

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }

    public NotificationStrategyEnum getNotificationStrategyEnum() {
        return notificationStrategyEnum;
    }

    public void setNotificationStrategyEnum(NotificationStrategyEnum notificationStrategyEnum) {
        this.notificationStrategyEnum = notificationStrategyEnum;
    }
}
