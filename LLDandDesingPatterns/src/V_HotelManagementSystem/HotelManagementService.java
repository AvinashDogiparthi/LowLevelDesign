package V_HotelManagementSystem;

import V_HotelManagementSystem.Booking.Booking;
import V_HotelManagementSystem.Booking.BookingStatus;
import V_HotelManagementSystem.PaymentStrategy.PaymentStrategy;
import V_HotelManagementSystem.PaymentStrategy.PaymentStrategyEnum;
import V_HotelManagementSystem.PaymentStrategy.PaymentStrategyFactory;
import V_HotelManagementSystem.Room.Room;
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

    public void bookARoom(String userID, String hotelID, String roomID, int checkInTime, PaymentStrategyEnum paymentStrategyEnum){

        if(userService.checkUserExistence(userID)){
            if(hotelMap.containsKey(hotelID)){
                Hotel hotel = hotelMap.get(hotelID);
                Room room = hotel.getASpecificRoom(roomID);
                if(Objects.nonNull(room)){
                    if(!room.isBookingDone()){
                        int amountPaid = room.calculateRoomPrice();
                        User user = userService.getUser(userID);
                        user.setWalletMoney(user.getWalletMoney() - amountPaid);
                        room.setBookingDone(true);
                        PaymentStrategy paymentStrategyToBeFollowed = PaymentStrategyFactory.getPaymentStrategy(paymentStrategyEnum);
                        paymentStrategyToBeFollowed.pay(amountPaid);
                        System.out.println("Booking done for room : "+roomID);
                        Booking booking = new Booking(userID,roomID,hotelID,RandomStringGenerator.generateRandomString(userID,hotelID,roomID,10),checkInTime,paymentStrategyToBeFollowed,amountPaid, BookingStatus.BOOKED);
                    } else {
                        System.out.println("Room is not available to book as it is booked by some other user, please select another room");
                    }
                } else {
                    System.out.println(" No such room exist, please use a valid one");
                }
            } else {
                System.out.println("no such hotel exist");
            }
        } else {
            System.out.println("No such user exist, please use a existing a valid one");
        }
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
        } else {
            System.out.println("no such user exist, please use a valid user to perfom operation");
        }
    }

    public void addRoom(String userID, String hotelID, String roomID, int defaultRoomPrice){

        if(userService.checkUserExistence(userID)){
            User user = userService.getUser(userID);
            if(user.getUserType() == UserType.ADMIN){
                if(this.hotelMap.containsKey(hotelID)){
                    Hotel hotel = hotelMap.get(hotelID);
                    Room room = hotel.getASpecificRoom(roomID);
                    if(Objects.nonNull(room)){
                        System.out.println("Such room already exist, so please edit it");
                    } else {
                        hotel.addRoom(roomID,defaultRoomPrice);
                        System.out.println("Successfully in adding a new room");
                    }
                } else {
                    System.out.println("no such hotel exist in the reservation system");
                }
            } else {
                System.out.println("user is not authorized to perform this operation");
            }
        } else {
            System.out.println("no such user exist, please use a valid user to perfom operation");
        }
    }

    public void removeRoom(String userID, String hotelID, String roomID){

        if(userService.checkUserExistence(userID)){
            User user = userService.getUser(userID);
            if(user.getUserType() == UserType.ADMIN){
                if(this.hotelMap.containsKey(hotelID)){
                    Hotel hotel = hotelMap.get(hotelID);
                    Room room = hotel.getASpecificRoom(roomID);
                    if(Objects.nonNull(room)){
                        System.out.println("Such room already exist, so please edit it");
                    } else {
                        hotel.removeRoom(roomID);
                        System.out.println("Successfully in removing a new room");
                    }
                } else {
                    System.out.println("no such hotel exist in the reservation system");
                }
            } else {
                System.out.println("user is not authorized to perform this operation");
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
