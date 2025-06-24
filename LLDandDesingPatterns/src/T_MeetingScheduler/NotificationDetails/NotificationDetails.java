package T_MeetingScheduler.NotificationDetails;

public class NotificationDetails {

    private int meetingID;
    private String message;
    private int userID;
    private String email;
    private long phoneNumber;

    public NotificationDetails(NotificationDetailsBuilder notificationDetailsBuilder) {
        this.meetingID = notificationDetailsBuilder.meetingID;
        this.email = notificationDetailsBuilder.email;
        this.userID = notificationDetailsBuilder.userID;
        this.phoneNumber = notificationDetailsBuilder.phoneNumber;
        this.message = notificationDetailsBuilder.message;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
