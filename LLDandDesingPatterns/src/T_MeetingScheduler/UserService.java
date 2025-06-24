package T_MeetingScheduler;

import T_MeetingScheduler.NotificationDetails.NotificationDetails;
import T_MeetingScheduler.NotificationDetails.NotificationStrategyFactory;
import T_MeetingScheduler.NotificationStrategy.NotificationStrategy;
import T_MeetingScheduler.NotificationStrategy.NotificationStrategyEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserService {

    Map<Integer,User> userMap;

    public UserService(){
        this.userMap = new HashMap<>();
    }

    public void notifyUser(NotificationDetails notificationDetails){
        User user = userMap.get(notificationDetails.getUserID());
        NotificationStrategy notificationStrategy = NotificationStrategyFactory.getNotificationStrategy(user.getNotificationStrategyEnum());

        if(Objects.nonNull(notificationStrategy)){
             System.out.println("UserService::notifyUser ---- proceeding with notification strategy "+notificationStrategy.toString()+" which is configured by user");
             notificationStrategy.notify(notificationDetails);
        } else {
            System.out.println("UserService::notifyUser ---- Invalid notification strategy (no class found) --- so halting the process");
            return;
        }
    }

    public User registerANewUser(int userID, NotificationStrategyEnum notificationStrategyEnum){

        User user = null;
        if(userMap.containsKey(userID)){
            System.out.println("UserService::registerANewUser --- user already exist, please update");
        } else {
            user = new User(userID, notificationStrategyEnum);
            userMap.put(userID,user);
        }

        return user;
    }

    public void updateExistingUserStrategy(int userID, NotificationStrategyEnum notificationStrategyEnum){
        if(userMap.containsKey(userID)){
            User user = userMap.get(userID);
            user.setNotificationStrategyEnum(notificationStrategyEnum);
            userMap.put(userID,user);
        } else {
            System.out.println("UserService::updateExistingUserStrategy --- user doesn't exist so cannot update user");
        }
    }

    public Map<Integer,User> getAvailableUsers(){
        return this.userMap;
    }
}
