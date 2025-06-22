package T_MeetingScheduler.MeetingRoom;

import T_MeetingScheduler.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomService {

    Map<Integer,MeetingRoom> mapOfMeetingRooms;

    public MeetingRoomService() {
        this.mapOfMeetingRooms = new HashMap<>();
    }

    public void addANewMeetingRoom(int meetingRoomID){

        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            System.out.println("MeetingRoomService::addANewMeetingRoom -- already a meeting room exist, please update the existing");
        } else {
            MeetingRoom meetingRoom = new MeetingRoom(meetingRoomID);
            mapOfMeetingRooms.put(meetingRoomID, meetingRoom);
        }
    }

    public void addMeetingSlot(String date, int fromTime, int meetingSlotID,int meetingRoomID){

        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            meetingRoom.addMeetingSlot(date, fromTime, meetingSlotID);
            System.out.println("MeetingRoomService::addMeetingSlot --- Added meeting slot");
        } else {
            System.out.println("MeetingRoomService::addMeetingSlot --- cannot add meeting slot as meeting room doesnt exist");
        }
    }

    public void removeMeetingSlot(String date, int meetingSlotID,int meetingRoomID) {
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            meetingRoom.removeMeetingSlot(date,meetingSlotID);
            System.out.println("MeetingRoomService::removeMeetingSlot --- removed meeting slot");
        } else {
            System.out.println("MeetingRoomService::removeMeetingSlot --- cannot remove meeting slot as meeting room doesnt exist");
        }
    }

    public void bookASlotInMeetingRoom(User meetingManger, List<User> participantsList, String date, int fromTime, int meetingSlotID, int meetingRoomID){
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            if(meetingRoom.checkIfSlotExists(date,meetingSlotID)){
                MeetingSlot meetingSlot = meetingRoom.returnMeetingSlot(date,meetingSlotID);
                if(!meetingSlot.isOccupied()){
                    meetingSlot.bookMeetingSlot(meetingManger,participantsList);
                } else {
                    System.out.println("MeetingRoomService::bookASlotInMeetingRoom --- meeting slot is not available");
                }
            } else {
                System.out.println("MeetingRoomService::bookASlotInMeetingRoom --- not meeting slot exits with the specified data and slotID");
            }
        } else {
            System.out.println("MeetingRoomService::bookASlotInMeetingRoom --- no meeting room exist with the sent room ID");
        }
    }
}
