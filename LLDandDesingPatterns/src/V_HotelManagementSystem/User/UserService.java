package V_HotelManagementSystem.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<String, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user){
        if(this.userMap.containsKey(user.getUserID())){
            System.out.println("User already exist in the system");
        } else {
            userMap.put(user.getUserID(), user);
        }
    }

    public void removeUser(String userID){
        if(this.userMap.containsKey(userID)){
            this.userMap.remove(userID);
            System.out.println("Successfully removed user");
        } else {
            System.out.println("no such user exist");
        }
    }

    public boolean checkUserExistence(String userID){
        if(this.userMap.containsKey(userID)){
            return true;
        }

        return false;
    }

    public User getUser(String userID){
        return this.userMap.get(userID);
    }
}
