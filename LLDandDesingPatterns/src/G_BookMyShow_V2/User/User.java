package G_BookMyShow_V2.User;

import G_BookMyShow_V2.Booking.Booking;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String userId;
    private String userName;
    // bookingID, booking object
    private Map<String, Booking> bookingMap;
    private String email;
    private int walletMoney;

    public User(String userId, String userName, String email){
        this.bookingMap = new HashMap<>();
        this.userId = userId;
        this.email = email;
        this.walletMoney = 0;
        this.userName = userName;
    }

    public User(String userId,String userName, String email, int walletMoney){
        this.bookingMap = new HashMap<>();
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.walletMoney = walletMoney;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }

    public void addBooking(Booking booking){
        this.bookingMap.put(booking.getBookingID(), booking);
    }

    public void removeBooking(String bookingID){
        this.bookingMap.remove(bookingID);
    }

    public Map<String, Booking> getAllBookings(){
        return this.bookingMap;
    }
}
