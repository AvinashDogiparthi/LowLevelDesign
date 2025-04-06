package E_CarRentalSystem;

public class Location
{
    String address;
    int pincode;
    String city;
    String state;
    String country;

    Location(int pincode,String city, String state, String country){
        this.pincode = pincode;
        this.country=country;
        this.city=city;
        this.state=state;
    }

}
