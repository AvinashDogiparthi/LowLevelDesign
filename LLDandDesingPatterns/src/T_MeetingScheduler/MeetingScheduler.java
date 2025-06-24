package T_MeetingScheduler;

import T_MeetingScheduler.MeetingRoom.MeetingRoomService;
import T_MeetingScheduler.MeetingRoom.MeetingSlot;
import T_MeetingScheduler.NotificationDetails.NotificationDetails;
import T_MeetingScheduler.NotificationDetails.NotificationDetailsBuilder;
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

    public void bookASlotInMeetingRoom(User meetingManger, List<User> participantsList, String date, int fromTime, int meetingSlotID, int meetingRoomID){
        boolean bookingDone = meetingRoomService.bookASlotInMeetingRoom(meetingManger,participantsList,date,fromTime,meetingSlotID,meetingRoomID);
        if(bookingDone){
            for(User user: participantsList){
                NotificationDetails notificationDetails = new NotificationDetailsBuilder()
                        .withMeetingID(meetingRoomID)
                        .withMessage("Blocking your calender for this meeting room")
                        .withEmail(Integer.toString(user.getUserID()))
                        .withPhoneNumber(Long.parseLong(Integer.toString(user.getUserID())))
                        .withUserID(user.getUserID())
                        .build();

                userService.notifyUser(notificationDetails);
            }
        }
    }

    public MeetingSlot getMeetingSlotUsingFromTime(String date, int meetingroomID,int fromTime){
       return meetingRoomService.getMeetingSlotusingFromTime(date,meetingroomID,fromTime);
    }

    public void cancelASlotInMeetingRoom(User meetingManger, List<User> participantsList, String date, int fromTime, int meetingSlotID, int meetingRoomID){
        boolean cancellationDone = meetingRoomService.cancelBookingDoneByUser(meetingManger,participantsList,date,fromTime,meetingSlotID,meetingRoomID);
        if(cancellationDone){
            for(User user: participantsList){
                NotificationDetails notificationDetails = new NotificationDetailsBuilder()
                        .withMeetingID(meetingRoomID)
                        .withMessage("Cancellation of booking")
                        .withEmail(Integer.toString(user.getUserID()))
                        .withPhoneNumber(Long.parseLong(Integer.toString(user.getUserID())))
                        .withUserID(user.getUserID())
                        .build();

                userService.notifyUser(notificationDetails);
            }
        }
    }
}
