package N_ZeptoStoreDesign;

public class User {
    public String userName;
    public int userID;
    public Location userLocation;
    public String cityName;
    public Cart userCart;

    public User(UserBuilder userBuilder) {
        this.cityName = userBuilder.cityName;
        this.userName = userBuilder.userName;
        this.userID = userBuilder.userID;
        this.userLocation = userBuilder.userLocation;
        this.userCart = userBuilder.userCart;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Location getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Location userLocation) {
        this.userLocation = userLocation;
    }

    public Cart getUserCart() {
        return userCart;
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }
}
