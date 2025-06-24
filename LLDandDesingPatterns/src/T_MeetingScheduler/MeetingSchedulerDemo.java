package T_MeetingScheduler;

import T_MeetingScheduler.MeetingRoom.MeetingSlot;
import T_MeetingScheduler.NotificationStrategy.NotificationStrategyEnum;

import java.util.Arrays;
import java.util.List;

public class MeetingSchedulerDemo {

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = MeetingScheduler.getInstance();

        User avinash = meetingScheduler.registerANewUser(14460);
        User deepak = meetingScheduler.registerANewUser(14459, NotificationStrategyEnum.EMAIL_NOTIFICATION);
        User vamshi = meetingScheduler.registerANewUser(1230);
        User preetham = meetingScheduler.registerANewUser(21212);
        User yogesh = meetingScheduler.registerANewUser(12132);

        meetingScheduler.addNewMeetingRoom(121312);
        meetingScheduler.addMeetingSlotsFor24Hours("23/6/25",121312);
        List<Integer> availableSlotsInNewMeetingRoom = meetingScheduler.getAvailableMeetingSlots(121312, "23/6/25");

        System.out.println("Available meeting slots : "+ availableSlotsInNewMeetingRoom.size());
        MeetingSlot meetingSlot = meetingScheduler.getMeetingSlotUsingFromTime("23/6/25",121312,1);

        if(!meetingSlot.isOccupied() && availableSlotsInNewMeetingRoom.contains(meetingSlot.getMeetingSlotID())){
            meetingScheduler.bookASlotInMeetingRoom(avinash, Arrays.asList(deepak,vamshi,preetham),"23/6/25",1,meetingSlot.getMeetingSlotID(),121312);
        }

        List<Integer> availableSlotsInNewMeetingRoom1 = meetingScheduler.getAvailableMeetingSlots(121312, "23/6/25");
        System.out.println("Available meeting slots : "+ availableSlotsInNewMeetingRoom1.size());

        meetingScheduler.cancelASlotInMeetingRoom(avinash, Arrays.asList(deepak,vamshi,preetham),"23/6/25",1,meetingSlot.getMeetingSlotID(),121312);

        List<Integer> availableSlotsInNewMeetingRoom2 = meetingScheduler.getAvailableMeetingSlots(121312, "23/6/25");
        System.out.println("Available meeting slots : "+ availableSlotsInNewMeetingRoom2.size());
    }
}
