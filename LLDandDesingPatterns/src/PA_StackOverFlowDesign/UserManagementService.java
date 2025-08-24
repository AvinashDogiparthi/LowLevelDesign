package PA_StackOverFlowDesign;

import java.util.HashMap;
import java.util.Map;

public class UserManagementService {

    private Map<Integer,User> userMap;

    public UserManagementService() {
        this.userMap = new HashMap<>();
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public User getUser(int userID){
        return this.userMap.get(userID);
    }

    public void addUser(int userId, String userName) {

        if(userMap.containsKey(userId)){
            System.out.println("UserManagementService::addUser -- user already exist");
        } else {
            User user = new User(userId,userName);
            this.userMap.put(user.getUserId(),user);
        }
    }

    public void addQuestion(int userID, int questionId, Question question){

        if(userMap.containsKey(userID)){

            User user = userMap.get(userID);
            user.updatePostedQuestion(questionId,question);
        } else {
            System.out.println("UserManagementService::addQuestion--no such user found");
        }
    }
}
