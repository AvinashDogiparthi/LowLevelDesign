package X_LibraryManagementSystem.User;

import X_LibraryManagementSystem.Book.Book;
import X_LibraryManagementSystem.Book.Notification;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagementService {

    private Map<String,User> availableUsersMap;

    public UserManagementService(){

        this.availableUsersMap = new HashMap<>();
    }

    public void registerANewUser(String userId, String userName, long phoneNumber, UserTypeEnum userTypeEnum){
        // Check if the user is already registered
        if(availableUsersMap.containsKey(userId)){
            System.out.println("UserManagementService::registerANewUser -- Current user is already a registered one");
        } else {
            User user = new User(userId,userName,phoneNumber,userTypeEnum);
            this.availableUsersMap.put(userId,user);
            System.out.println("UserManagementService::registerANewUser -- Successful in registering a new user");
        }
    }

    public boolean isUserAlreadyARegisteredOne(String userId){
        return this.availableUsersMap.containsKey(userId);
    }

    public User getUser(String userId){
        return this.availableUsersMap.get(userId);
    }

    public void updateUserDetails(User user){
        this.availableUsersMap.put(user.getUserID(), user);
        System.out.println("Successful in updating user details");
        System.out.println("User name : "+user.getUserName()+" User ID : "+user.getUserID()+" User Phone Number : "+user.getPhoneNumber()+" User Type :"+user.getUserTypeEnum());
    }

    public void notifyUsers(Book book, List<String> userIDs){

        long timeStamp = Instant.now().toEpochMilli();
        Notification notification = new Notification(book.getBookId(),String.format("Book : {}-{} is now available",book.getBookId(),book.getBookName()), timeStamp);
        for(String userId : userIDs){
            if(this.availableUsersMap.containsKey(userId)){
                User user = this.availableUsersMap.get(userId);
                user.pushNotificationIntoQueue(notification);
            }
        }

        System.out.println("UserManagementService::notifyUsers -- notified to " +book.getUserWaitingQueue().size()+" users ");
    }
}
