package T_MeetingScheduler.MeetingRoom;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomService {

    Map<String,MeetingRoom> mapOfMeetingRooms;

    public MeetingRoomService() {
        this.mapOfMeetingRooms = new HashMap<>();
    }
}
