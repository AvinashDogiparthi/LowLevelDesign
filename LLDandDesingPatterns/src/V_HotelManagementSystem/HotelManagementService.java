package V_HotelManagementSystem;

import V_HotelManagementSystem.Booking.Booking;
import V_HotelManagementSystem.User.User;
import V_HotelManagementSystem.User.UserService;
import V_HotelManagementSystem.User.UserType;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HotelManagementService {

    private static HotelManagementService INSTANCE = null;
    private Map<String, List<Booking>> userBookingsMap;
    private Map<String, Hotel> hotelMap;
    // <hotelID, < bookingID, Booking>>
    private Map<String, Map<String, Booking>> hotelBookingsMap;
    private UserService userService;
    private Map<String, Booking> bookingMap;

    private HotelManagementService() {
        this.userBookingsMap = new HashMap<>();
        this.hotelMap = new HashMap<>();
        this.bookingMap = new HashMap<>();
        this.hotelBookingsMap = new HashMap<>();
    }

    public static HotelManagementService getInstance(){

        if(INSTANCE == null){
            INSTANCE = new HotelManagementService();
        }
        return INSTANCE;
    }

    public void addHotel(String hotelID,String hotelName, String userID){

        if(userService.checkUserExistence(userID)){
            User user = userService.getUser(userID);
            if(user.getUserType() == UserType.ADMIN){
                if(this.hotelMap.containsKey(hotelID)){
                    this.hotelMap.remove(hotelID);
                    this.hotelBookingsMap.put(hotelID, new HashMap<>());
                    System.out.println("Successfully in removing hotel from the reservation system");
                } else {
                    System.out.println("NO such hotel exist, please do valid operation");
                }
            } else {
                System.out.println("user is not authorized to perform this operation");
            }
        } else {
            System.out.println("no such user exist, please use a valid user to perfom operation");
        }
    }

    public void removeHotel(String hotelID, String userID){

        if(userService.checkUserExistence(userID)){
            User user = userService.getUser(userID);
            if(user == null){
                System.out.println("no such user exist, invalid operation");
            } else {
                if(user.getUserType() == UserType.ADMIN){
                    if(this.hotelMap.containsKey(hotelID)){
                        this.hotelMap.remove(hotelID);
                        System.out.println("Successfully in removing hotel from the reservation system");
                    } else {
                        System.out.println("NO such hotel exist, please do valid operation");
                    }
                } else {
                    System.out.println("user is not authorized to perform this operation");
                }
            }
        } else {
            System.out.println("no such user exist, please use a valid user to perfom operation");
        }
    }

    public void addBookingsIntoHotel(String hotelID, String bookingID){
        if(this.hotelMap.containsKey(hotelID)){
            Booking booking = this.bookingMap.get(bookingID);

            if(Objects.nonNull(booking)){
                Map<String, Booking> hotelBookingMap = this.hotelBookingsMap.get(hotelID);
                hotelBookingMap.put(bookingID,booking);
            } else {
                System.out.println("No such booking exist with the specified bookingID");
            }
        } else {
            System.out.println("No such hotel exist in the reservation system");
        }
    }
}
