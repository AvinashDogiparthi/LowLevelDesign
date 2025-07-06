package V_HotelManagementSystem.Room;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String roomID;
    private List<RoomType> roomTypeList;
    private boolean isBookingDone;
    private int defaultRoomPrice;

    public Room(String roomID, int defaultRoomPrice) {
        this.roomID = roomID;
        this.defaultRoomPrice = defaultRoomPrice;
        this.roomTypeList = new ArrayList<>();
        this.isBookingDone = false;
    }

    public void addRoomType(RoomType roomType){
        if(this.roomTypeList.contains(roomType)){
            System.out.println("already room is specified with similar room type");
        } else {
            this.roomTypeList.add(roomType);
        }
    }

    public int calculateRoomPrice(){
        int price = defaultRoomPrice;

        for(RoomType roomType : roomTypeList){
            price = price + roomType.getPrice();
        }

        return price;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public List<RoomType> getRoomTypeList() {
        return roomTypeList;
    }

    public void setRoomTypeList(List<RoomType> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

    public boolean isBookingDone() {
        return isBookingDone;
    }

    public void setBookingDone(boolean bookingDone) {
        isBookingDone = bookingDone;
    }

    public int getDefaultRoomPrice() {
        return defaultRoomPrice;
    }

    public void setDefaultRoomPrice(int defaultRoomPrice) {
        this.defaultRoomPrice = defaultRoomPrice;
    }
}
