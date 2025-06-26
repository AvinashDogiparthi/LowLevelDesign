package U_FlightBookingManagement.User;

import U_FlightBookingManagement.NotificationStrategy.utils.NotificationStrategyEnum;
import U_FlightBookingManagement.Seat.SeatCategoryEnum;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static UserService instance = null;
    private Map<Integer, User> userMap;

    private UserService(){
        userMap = new HashMap<>();
    }

    public static synchronized UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }

        return instance;
    }

    public User registerUser(int userID){

        if(userMap.containsKey(userID)){
            return userMap.get(userID);
        }
        User user = new User(userID);
        userMap.put(userID,user);

        return user;
    }

    public User registerUser(int userID, SeatCategoryEnum seatCategoryEnum, NotificationStrategyEnum notificationStrategyEnum){

        if(userMap.containsKey(userID)){
            return userMap.get(userID);
        }
        User user = new User(userID, seatCategoryEnum, notificationStrategyEnum);
        userMap.put(userID,user);

        return user;
    }

    public User registerUser(int userID, SeatCategoryEnum seatCategoryEnum, int walletMoney){

        if(userMap.containsKey(userID)){
            return userMap.get(userID);
        }
        User user = new User(userID, seatCategoryEnum, walletMoney);
        userMap.put(userID,user);

        return user;
    }

    public User getUser(int userID){
        return userMap.get(userID);
    }
}
