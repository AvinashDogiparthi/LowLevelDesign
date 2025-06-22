package T_MeetingScheduler;

import T_MeetingScheduler.NotificationStrategy.NotificationStrategyEnum;

public class User {

    private int userID;
    private NotificationStrategyEnum notificationStrategyEnum;

    public User(int userID, NotificationStrategyEnum notificationStrategyEnum) {
        this.userID = userID;
        this.notificationStrategyEnum = notificationStrategyEnum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public NotificationStrategyEnum getNotificationStrategyEnum() {
        return notificationStrategyEnum;
    }

    public void setNotificationStrategyEnum(NotificationStrategyEnum notificationStrategyEnum) {
        this.notificationStrategyEnum = notificationStrategyEnum;
    }
}
