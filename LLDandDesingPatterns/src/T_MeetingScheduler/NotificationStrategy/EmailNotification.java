package T_MeetingScheduler.NotificationStrategy;

import T_MeetingScheduler.NotificationDetails.NotificationDetails;

public class EmailNotification implements NotificationStrategy {

    @Override
    public void notify(NotificationDetails notificationDetails) {
        System.out.println("EmailNotification::notify -- notification process has started now");
        System.out.println("EmailNotification::notify -- notification has been sent to email number "+ notificationDetails.getEmail());
    }
}
