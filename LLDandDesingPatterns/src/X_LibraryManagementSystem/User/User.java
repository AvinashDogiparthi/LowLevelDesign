package X_LibraryManagementSystem.User;

import X_LibraryManagementSystem.Book.Notification;
import X_LibraryManagementSystem.Order.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {

    private String userID;
    private String userName;
    private long phoneNumber;
    private UserTypeEnum userTypeEnum;
    private Queue<Notification> notificationQueue;
    private List<Order> borrowHistory;
    private boolean isElgibile;

    public User(String userID, String userName, long phoneNumber, UserTypeEnum userTypeEnum){
        this.userID = userID;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.userTypeEnum = userTypeEnum;
        this.notificationQueue = new LinkedList<>();
        this.isElgibile = true;
        borrowHistory = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public void pushNotificationIntoQueue(Notification notification){
        this.notificationQueue.add(notification);
    }

    private List<Notification> notificationList(){
        return this.notificationQueue.stream().toList();
    }

    public List<Order> getBorrowHistory() {
        return borrowHistory;
    }

    public void addOrderIntoUserBorrowHistory(Order order) {
        this.borrowHistory.add(order);
    }

    public boolean isElgibile() {
        return isElgibile;
    }

    public void setElgibile(boolean elgibile) {
        isElgibile = elgibile;
    }
}
