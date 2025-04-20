package B_DesignPatterns.N_FlyweightDesignPattern;

import java.util.Map;

public class UserImage {
    public String userImageAddress;
    public String userURL;
    public String userName;

    public UserImage(String userURL, String userImageAddress) {
        this.userURL = userURL;
        this.userImageAddress = userImageAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
