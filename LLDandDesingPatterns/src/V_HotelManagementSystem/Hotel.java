package V_HotelManagementSystem;

import V_HotelManagementSystem.Room.Room;
import V_HotelManagementSystem.Room.RoomType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

    private String hotelID;
    private String hotelName;

    // <roomID, ROOM >
    private Map<String, Room> mapOfRooms;

    public Hotel(String hotelID, String hotelName) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.mapOfRooms = new HashMap<>();
    }

    public void addRoom(String roomID, int defaultRoomPrice){

        if(this.mapOfRooms.containsKey(roomID)){
            System.out.println("Room already exist with specified room ID, please use a different one");
        } else {
            Room room = new Room(roomID,defaultRoomPrice);
            this.mapOfRooms.put(roomID,room);
        }
    }

    public void removeRoom(String roomID){
        if(this.mapOfRooms.containsKey(roomID)){
            mapOfRooms.remove(roomID);
        } else {
            System.out.println("No such room exist with specified room ID");
        }
    }

    public Room getASpecificRoom(String roomID){
        return this.mapOfRooms.get(roomID);
    }

    public void editBookingStatusOfaSpecificRoom(String roomID,boolean bookingDone){

        if(mapOfRooms.containsKey(roomID)){
            Room room = mapOfRooms.get(roomID);
            room.setBookingDone(bookingDone);
        } else {
            System.out.println("No such room exist with the specidied room ID");
        }
    }

    public void addRoomTypesToASpecificROOm(String roomID, List<RoomType> roomTypeList){

        if(mapOfRooms.containsKey(roomID)){
            Room room = mapOfRooms.get(roomID);
            appendRoomTypesToRoom(roomTypeList, room);
        } else {
            System.out.println("No such room exist with the specidied room ID");
        }
    }

    private static void appendRoomTypesToRoom(List<RoomType> roomTypeList, Room room) {
        for(RoomType roomType: roomTypeList){
            room.addRoomType(roomType);
            room.addRoomType(roomType);
        }
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Map<String, Room> getMapOfRooms() {
        return mapOfRooms;
    }

    public void setMapOfRooms(Map<String, Room> mapOfRooms) {
        this.mapOfRooms = mapOfRooms;
    }

    public void addRoomTypes(String roomID, List<RoomType> roomTypes){

        if(this.mapOfRooms.containsKey(roomID)){
            Room room = mapOfRooms.get(roomID);
            for(RoomType roomType : roomTypes){
                room.addRoomType(roomType);
            }
            System.out.println("Addition of room types to room : "+roomID+" is done");
            System.out.println("Price revision after adding room types to room : "+roomID+" is : "+room.calculateRoomPrice());
        } else {
            System.out.println("no such room exist with room ID "+roomID);
        }
    }
}
