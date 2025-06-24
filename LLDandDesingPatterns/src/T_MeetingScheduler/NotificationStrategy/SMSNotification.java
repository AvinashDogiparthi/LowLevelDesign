package T_MeetingScheduler.NotificationStrategy;

import T_MeetingScheduler.NotificationDetails.NotificationDetails;

public class SMSNotification implements NotificationStrategy {

    @Override
    public void notify(NotificationDetails notificationDetails) {
        System.out.println("SMSNotification::notify -- notification process has started now");
        System.out.println("SMSNotification::notify -- notification has been sent to phone number "+ notificationDetails.getPhoneNumber());
    }
}
