package T_MeetingScheduler;

import T_MeetingScheduler.NotificationStrategy.EmailNotification;
import T_MeetingScheduler.NotificationStrategy.NotificationStrategy;
import T_MeetingScheduler.NotificationStrategy.NotificationStrategyEnum;
import T_MeetingScheduler.NotificationStrategy.SMSNotification;

public class NotificationStrategyFactory {

    public static NotificationStrategy getNotificationStrategy(NotificationStrategyEnum notificationStrategyEnum){
        if(notificationStrategyEnum == NotificationStrategyEnum.SMS_NOTIFICATION){
            return new SMSNotification();
        } else if (notificationStrategyEnum == NotificationStrategyEnum.EMAIL_NOTIFICATION){
            return new EmailNotification();
        } else {
            return null;
        }
    }
}
