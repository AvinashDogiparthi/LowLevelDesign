package O_CultFitDesign.User;

import O_CultFitDesign.Booking.Booking;
import O_CultFitDesign.Slot;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int userId;

    public String userName;

    public long phoneNumber;

    public UserType userType;

    public List<Booking> bookingList;

    public User(int userId, String userName, long phoneNumber, UserType userType) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.bookingList = new ArrayList<>();
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void addBooking(Booking booking){
        this.bookingList.add(booking);
    }

    public void notifyUserRegardingRegistration(Slot slot){
        System.out.println("User::notifyUserRegardingRegistration - User"+userId+" phone number :"+phoneNumber+" registration successful for slot"+slot);
        System.out.println("User::notifyUserRegardingRegistration - Your registration went through and it was successful now");
    }

    public void notifyUserRegardingSlotCancellation(Slot slot){
        System.out.println("User::notifyUserRegardingSlotCancellation - Registration which was done is cancelled for Slot : "+slot);
        System.out.println("User::notifyUserRegardingSlotCancellation - REFUND INITIATED");
    }
}
