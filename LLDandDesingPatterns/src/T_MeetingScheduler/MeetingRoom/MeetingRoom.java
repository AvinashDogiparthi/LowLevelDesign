package T_MeetingScheduler.MeetingRoom;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoom {

    private Map<String, Map<Integer,MeetingSlot>>  meetingSlots;
    private int meetingRoomID;

    public MeetingRoom(int meetingRoomID) {
        this.meetingRoomID = meetingRoomID;
        this.meetingSlots = new HashMap<>();
    }

    public int getMeetingRoomID() {
        return meetingRoomID;
    }

    public void setMeetingRoomID(int meetingRoomID) {
        this.meetingRoomID = meetingRoomID;
    }

    public void addMeetingSlot(String date, int fromTime, int meetingSlotID){
        if(meetingSlots.containsKey(date)){
            MeetingSlot meetingSlot = new MeetingSlot(fromTime,meetingSlotID);
            Map<Integer,MeetingSlot> meetingSlotMap = meetingSlots.get(date);
            if(meetingSlotMap.containsKey(fromTime)){
                System.out.println("MeetingRoom::addMeetingSlot --- already meeting slot exist with same details, so updating it");
                meetingSlotMap.put(fromTime,meetingSlot);
                System.out.println("MeetingRoom::addMeetingSlot --- Updated the slot");
            } else {
                System.out.println("MeetingRoom::addMeetingSlot --- no meeting slot exist with provided details");
                meetingSlotMap.put(fromTime,meetingSlot);
                System.out.println("MeetingRoom::addMeetingSlot --- Created the slot");
            }
        } else {
            System.out.println("MeetingRoom::addMeetingSlot --- no meeting room exist with specified date");
            MeetingSlot meetingSlot = new MeetingSlot(fromTime,meetingSlotID);
            Map<Integer,MeetingSlot> meetingSlotMap = new HashMap<>();
            meetingSlotMap.put(fromTime,meetingSlot);

            meetingSlots.put(date,meetingSlotMap);
        }
    }

    public void removeMeetingSlot(String date, int meetingSlotID){
        if(meetingSlots.containsKey(date)){
            Map<Integer,MeetingSlot> meetingSlotHashMap = meetingSlots.get(date);
            int slotFromTime = -1;
            for(MeetingSlot meetingSlot : meetingSlotHashMap.values()){
                int id = meetingSlot.getMeetingSlotID();
                if(id == meetingSlotID){
                    System.out.println("MeetingRoom::removeMeetingSlot --- retrieved meeting room details");
                    slotFromTime = meetingSlot.getFromTime();
                }
            }

            if(slotFromTime >= 0){
                meetingSlotHashMap.remove(slotFromTime);
                System.out.println("MeetingRoom::removeMeetingSlot --- removed meeting slot");
            } else {
                System.out.println("MeetingRoom::removeMeetingSlot --- no slot exist in specified date");
            }
        } else {
            System.out.println("MeetingRoom::removeMeetingSlot --- no meeting slot exist in this date");
        }
    }
}
