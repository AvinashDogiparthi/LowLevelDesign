package U_FlightBookingManagement.NotificationStrategy.utils;

import U_FlightBookingManagement.NotificationStrategy.EmailNotification;
import U_FlightBookingManagement.NotificationStrategy.NotificationStrategy;
import U_FlightBookingManagement.NotificationStrategy.SMSNotification;

public class NotificationStrategyFactory {

    public static NotificationStrategy getNotificationStrategy(NotificationStrategyEnum notificationStrategyEnum){

        if(notificationStrategyEnum == NotificationStrategyEnum.EMAIL){
            return new EmailNotification();
        }

        return new SMSNotification();
    }
}
