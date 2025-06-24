package T_MeetingScheduler.MeetingRoom;

import java.util.*;

public class MeetingRoom {

    // Map<date, Map<meetingslotID, meetingSlot>>
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
            System.out.println("MeetingRoom::addMeetingSlot --- no meeting slots exist with specified date");
            MeetingSlot meetingSlot = new MeetingSlot(fromTime,meetingSlotID);
            Map<Integer,MeetingSlot> meetingSlotMap = new HashMap<>();
            meetingSlotMap.put(fromTime,meetingSlot);

            meetingSlots.put(date,meetingSlotMap);
            System.out.println("MeetingRoom::addMeetingSlot --- created new slots as no slots exist for this date before");
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

    public boolean checkIfSlotExists(String date,int meetingSLotID){
        boolean existence = false;
        if(meetingSlots.containsKey(date)){
            Map<Integer,MeetingSlot> meetingSlotMap = meetingSlots.get(date);

            for(MeetingSlot meetingSlot : meetingSlotMap.values()){
                if(meetingSlot.getMeetingSlotID() == meetingSLotID){
                    existence = true;
                }
            }
        }

        return existence;
    }

    public MeetingSlot returnMeetingSlot(String date,int meetingSLotID){
        MeetingSlot returnablemeetingSlot = null;
        if(meetingSlots.containsKey(date)){
            Map<Integer,MeetingSlot> meetingSlotMap = meetingSlots.get(date);

            for(MeetingSlot meetingSlot : meetingSlotMap.values()){
                if(meetingSlot.getMeetingSlotID() == meetingSLotID){
                    returnablemeetingSlot = meetingSlot;
                }
            }
        }

        return returnablemeetingSlot;
    }

    public void addMeetingSlotsForDate(String date){
        Map<Integer,MeetingSlot> meetingSlotMap = new HashMap<>();
        for(int i = 0;i<24;i++){
            MeetingSlot meetingSlot = new MeetingSlot(i,i*100);
            meetingSlotMap.put(i,meetingSlot);
        }
        meetingSlots.put(date,meetingSlotMap);
    }

    public List<Integer> getAvailableMeetingSlots(String date){
        List<Integer> availableMeetingSlotIDs = new ArrayList<>();
        Map<Integer, MeetingSlot> availableMeetingSlots = meetingSlots.get(date);

        for(MeetingSlot meetingSlot : availableMeetingSlots.values()){
            if(!meetingSlot.isOccupied()){
                availableMeetingSlotIDs.add(meetingSlot.getMeetingSlotID());
            }
        }

        return availableMeetingSlotIDs;
    }

    public MeetingSlot getMeetingSlotUsingFromTime(String date, int fromTime){
        MeetingSlot returnableMeetingSlot = null;
        if(meetingSlots.containsKey(date)){
            Map<Integer,MeetingSlot> meetingSlotMap = meetingSlots.get(date);

            for(MeetingSlot meetingSlot : meetingSlotMap.values()){
                if(meetingSlot.getFromTime() == fromTime){
                    returnableMeetingSlot = meetingSlot;
                }
            }
        }

        return returnableMeetingSlot;
    }
}
