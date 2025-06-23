package T_MeetingScheduler.MeetingRoom;

import T_MeetingScheduler.User;

import java.util.*;

public class MeetingRoomService {

    // meetingRoomId, meetingRoom object
    Map<Integer,MeetingRoom> mapOfMeetingRooms;

    public MeetingRoomService() {
        this.mapOfMeetingRooms = new HashMap<>();
        addMeetingRooms();
        addMeetingSlots();
    }

    private void addMeetingRooms() {

        for(int i = 0;i<15;i++){
            MeetingRoom meetingRoom = new MeetingRoom(i);
            mapOfMeetingRooms.put(i,meetingRoom);
        }
    }

    private void addMeetingSlots(){
        List<String> dates = Arrays.asList("23/6/2025","22/6/2025");
        for(String date : dates){
            for(MeetingRoom meetingRoom : mapOfMeetingRooms.values()){
                for(int i = 0;i<=24;i++){
                    meetingRoom.addMeetingSlot(date,i,i*100);
                }
            }
        }
    }

    public void addANewMeetingRoom(int meetingRoomID){

        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            System.out.println("MeetingRoomService::addANewMeetingRoom -- already a meeting room exist, please update the existing");
        } else {
            MeetingRoom meetingRoom = new MeetingRoom(meetingRoomID);
            mapOfMeetingRooms.put(meetingRoomID, meetingRoom);
            System.out.println("MeetingRoomService::addANewMeetingRoom -- successfully created a new meeting room");
        }
    }

    public void removeAMeetingRoom(int meetingRoomID){
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            mapOfMeetingRooms.remove(meetingRoomID);
            System.out.println("MeetingRoomService::removeAMeetingRoom -- successfully removed a meeting room");
        } else {
            System.out.println("MeetingRoomService::removeAMeetingRoom -- no meeting room exist with the mentioned meeting room ID");
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

    public boolean bookASlotInMeetingRoom(User meetingManger, List<User> participantsList, String date, int fromTime, int meetingSlotID, int meetingRoomID){
        boolean bookingDone = false;
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            if(meetingRoom.checkIfSlotExists(date,meetingSlotID)){
                MeetingSlot meetingSlot = meetingRoom.returnMeetingSlot(date,meetingSlotID);
                if(!meetingSlot.isOccupied()){
                    meetingSlot.bookMeetingSlot(meetingManger,participantsList);
                    bookingDone = true;
                } else {
                    System.out.println("MeetingRoomService::bookASlotInMeetingRoom --- meeting slot is not available");
                }
            } else {
                System.out.println("MeetingRoomService::bookASlotInMeetingRoom --- not meeting slot exits with the specified data and slotID");
            }
        } else {
            System.out.println("MeetingRoomService::bookASlotInMeetingRoom --- no meeting room exist with the sent room ID");
        }

        return bookingDone;
    }

    public void addMeetingSlotsForSpecifiedDate(String date, int meetingRoomID){
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            meetingRoom.addMeetingSlotsForDate(date);
        } else {
            System.out.println("MeetingRoomService::addMeetingSlotsForSpecifiedDate --- no meeting room exist with the sent meetingRoomID");
        }
    }

    public Map<Integer,MeetingRoom> getMapOfMeetingRooms(){
        return mapOfMeetingRooms;
    }

    public List<Integer> getAvailableMeetingSlots(int meetingRoomID,String date){
        List<Integer> availableMeetingSlots = new ArrayList<>();
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            availableMeetingSlots = meetingRoom.getAvailableMeetingSlots(date);
        } else {
            System.out.println("MeetingRoomService::getAvailableMeetingSlots --- no meeting room available with mentioned meeting room ID");
        }

        return availableMeetingSlots;
    }

    public MeetingSlot getMeetingSlotusingFromTime(String date, int meetingRoomID, int fromTime){
        MeetingSlot meetingSlot = null;
        if(mapOfMeetingRooms.containsKey(meetingRoomID)){
            MeetingRoom meetingRoom = mapOfMeetingRooms.get(meetingRoomID);
            meetingSlot = meetingRoom.getMeetingSlotUsingFromTime(date,fromTime);
        } else {
            System.out.println("MeetingRoomService::getMeetingSlotusingFromTime --- NO MEETING ROOM exist");
        }

        return meetingSlot;
    }
}
