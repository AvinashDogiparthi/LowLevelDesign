package T_MeetingScheduler;

import T_MeetingScheduler.NotificationStrategy.NotificationStrategy;

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
}
