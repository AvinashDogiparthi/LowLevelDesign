package T_MeetingScheduler.NotificationDetails;

public class NotificationDetailsBuilder{
    public int meetingID;
    public String message;
    public int userID;
    public String email;
    public long phoneNumber;

    public NotificationDetailsBuilder withMeetingID(int meetingID){
        this.meetingID = meetingID;
        return this;
    }

    public NotificationDetailsBuilder withMessage(String message){
        this.message = message;
        return this;
    }

    public NotificationDetailsBuilder withUserID(int userID){
        this.userID = userID;
        return this;
    }

    public NotificationDetailsBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public NotificationDetailsBuilder withPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public NotificationDetails build(){
        return new NotificationDetails(this);
    }
}
