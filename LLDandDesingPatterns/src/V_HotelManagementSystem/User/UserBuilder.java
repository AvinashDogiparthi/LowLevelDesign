package V_HotelManagementSystem.User;

public class UserBuilder {

    protected String userID;
    protected String userName;
    protected String email;
    protected long phoneNumber;
    protected UserType userType;
    protected int walletMoney = 0;

    public UserBuilder withUserId(String userID){
        this.userID = userID;
        return this;
    }

    public UserBuilder withUserName(String userName){
        this.userName = userName;
        return this;
    }

    public UserBuilder withUserEmail(String email){
        this.email = email;
        return this;
    }

    public UserBuilder withPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder withUserType(UserType userType){
        this.userType = userType;
        return this;
    }

    public UserBuilder withWalletMoney(int money){
        this.walletMoney = money;
        return this;
    }

    public User build(){
        return new User(this);
    }
}
