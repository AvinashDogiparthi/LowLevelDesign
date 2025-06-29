package G_BookMyShow_V2.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> mapOfUsers;

    public UserService() {
        this.mapOfUsers = new HashMap<>();
    }

    public void registerUser(String userID, String userName, String email ){
        if(!mapOfUsers.containsKey(userID)){
            System.out.println("UserService::registerUser -- registering a new user");
            User user = new User(userID,userName,email);
            this.mapOfUsers.put(userID,user);
        } else {
            System.out.println("UserService::registerUser -- user already exist in the system");
        }
    }

    public void registerUser(String userID, String userName, String email , int walletBalance){
        if(!mapOfUsers.containsKey(userID)){
            System.out.println("UserService::registerUser -- registering a new user");
            User user = new User(userID,userName,email,walletBalance);
            this.mapOfUsers.put(userID,user);
        } else {
            System.out.println("UserService::registerUser -- user already exist in the system");
        }
    }

    public void updateUserWalletBalance(String userId, int amount){
        User user = mapOfUsers.get(userId);
        user.setWalletMoney(user.getWalletMoney() + amount);
        System.out.println("UserService::updateUserWalletBalance -- added requested amount to user wallet");
    }

    public User getUser(String userId){
        return this.mapOfUsers.get(userId);
    }
}
