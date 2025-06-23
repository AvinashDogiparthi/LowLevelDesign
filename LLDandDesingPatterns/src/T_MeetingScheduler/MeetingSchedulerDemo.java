package T_MeetingScheduler;

import T_MeetingScheduler.NotificationStrategy.NotificationStrategyEnum;

public class MeetingSchedulerDemo {

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = MeetingScheduler.getInstance();

        User avinash = meetingScheduler.registerANewUser(14460);
        User deepak = meetingScheduler.registerANewUser(14459, NotificationStrategyEnum.EMAIL_NOTIFICATION);
        User vamshi = meetingScheduler.registerANewUser(1230);
        User preetham = meetingScheduler.registerANewUser(21212);
        User yogesh = meetingScheduler.registerANewUser(12132);



    }
}
