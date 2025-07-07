package V_HotelManagementSystem.User;

public class User {

    private String userID;
    private String userName;
    private String email;
    private long phoneNumber;
    private UserType userType;
    private int walletMoney;

    protected User(UserBuilder userBuilder){
        this.userID = userBuilder.userID;
        this.userName = userBuilder.userID;
        this.email = userBuilder.email;
        this.phoneNumber = userBuilder.phoneNumber;
        this.userType = userBuilder.userType;
        this.walletMoney = userBuilder.walletMoney;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }

    public void increaseWalletMoney(int incrementMoney){
        this.walletMoney += incrementMoney;
    }
}
