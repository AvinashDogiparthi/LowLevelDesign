package V_HotelManagementSystem.Booking;

import V_HotelManagementSystem.PaymentStrategy.PaymentStrategy;

public class Booking {

    private String userID;
    private String roomID;
    private String hotelID;
    private String bookingID;
    private int checkInTime;
    private int checkOutTime;
    private PaymentStrategy paymentStrategy;
    private int amountPaid;
    private BookingStatus bookingStatus;

    public Booking(){

    }

    public Booking(String userID, String roomID, String hotelID, String bookingID, int checkInTime, PaymentStrategy paymentStrategy, int amountPaid, BookingStatus bookingStatus) {
        this.userID = userID;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.bookingID = bookingID;
        this.checkInTime = checkInTime;
        this.checkOutTime = 0;
        this.paymentStrategy = paymentStrategy;
        this.amountPaid = amountPaid;
        this.bookingStatus = bookingStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public int getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(int checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(int checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
