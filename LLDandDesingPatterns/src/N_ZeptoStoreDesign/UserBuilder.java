package N_ZeptoStoreDesign;

public class UserBuilder {
    public String userName;
    public int userID;
    public Location userLocation;
    public String cityName;
    public Cart userCart;

    public UserBuilder withUserName(String userName){
        this.userName = userName;
        return this;
    }

    public UserBuilder withUserID(int userId){
        this.userID = userId;
        return this;
    }

    public UserBuilder withUserLocation(Location location){
        this.userLocation = location;
        return this;
    }

    public UserBuilder withCityName(String cityName){
        this.cityName = cityName;
        return this;
    }

    public UserBuilder withCart(Cart cart){
        this.userCart = cart;
        return this;
    }

    public User build(){
        return new User(this);
    }
}
