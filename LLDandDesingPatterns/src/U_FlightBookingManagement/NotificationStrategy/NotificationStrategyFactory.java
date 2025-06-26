package U_FlightBookingManagement.NotificationStrategy;

public class NotificationStrategyFactory {

    public static NotificationStrategy getNotificationStrategy(NotificationStrategyEnum notificationStrategyEnum){

        if(notificationStrategyEnum == NotificationStrategyEnum.EMAIL){
            return new EmailNotification();
        }

        return new SMSNotification();
    }
}
