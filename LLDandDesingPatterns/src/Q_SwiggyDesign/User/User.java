package Q_SwiggyDesign.User;

public abstract class User {

    public User(int userId, String name, UserType userType) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
    }

    private int userId;
    private String name;
    private UserType userType;

}
