package T_MeetingScheduler;

import T_MeetingScheduler.MeetingRoom.MeetingRoomService;
import T_MeetingScheduler.NotificationStrategy.NotificationStrategyEnum;

import java.util.List;
import java.util.Objects;

public class MeetingScheduler {

    private static MeetingScheduler instance = null;

    private UserService userService;
    private MeetingRoomService meetingRoomService;

    private MeetingScheduler(){
        userService = new UserService();
        meetingRoomService = new MeetingRoomService();
    }

    public static synchronized MeetingScheduler getInstance(){
        if(instance == null){
            instance = new MeetingScheduler();
        }

        return instance;
    }

    public User registerANewUser(int userID){
        User user = userService.registerANewUser(userID, NotificationStrategyEnum.SMS_NOTIFICATION);
        return (Objects.nonNull(user))?user:null;
    }

    public User registerANewUser(int userID,NotificationStrategyEnum notificationStrategyEnum){
        User user = userService.registerANewUser(userID, notificationStrategyEnum);
        return (Objects.nonNull(user))?user:null;
    }

    public void addNewMeetingRoom(int meetingRoomID){
        meetingRoomService.addANewMeetingRoom(meetingRoomID);
    }

    public void removeAMeetingRoom(int meetingRoomID){
        meetingRoomService.removeAMeetingRoom(meetingRoomID);
    }

    public void addMeetingSlotsFor24Hours(String date, int meetingRoomID){
        meetingRoomService.addMeetingSlotsForSpecifiedDate(date,meetingRoomID);
    }

    public void removeMeetingSlot(String date, int meetingslotID, int meetingRoomId){
        meetingRoomService.removeMeetingSlot(date,meetingslotID,meetingRoomId);
    }

    public List<Integer> getAvailableMeetingSlots(int meetingRoomID, String date){
        return meetingRoomService.getAvailableMeetingSlots(meetingRoomID,date);
    }

    public void bookASlotInMeetingRoom(){
    }
}
