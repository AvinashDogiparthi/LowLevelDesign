package V_HotelManagementSystem;

import V_HotelManagementSystem.Booking.Booking;
import V_HotelManagementSystem.Booking.BookingStatus;
import V_HotelManagementSystem.PaymentStrategy.PaymentStrategy;
import V_HotelManagementSystem.PaymentStrategy.PaymentStrategyEnum;
import V_HotelManagementSystem.PaymentStrategy.PaymentStrategyFactory;
import V_HotelManagementSystem.Room.Room;
import V_HotelManagementSystem.Room.RoomType;
import V_HotelManagementSystem.User.User;
import V_HotelManagementSystem.User.UserBuilder;
import V_HotelManagementSystem.User.UserService;
import V_HotelManagementSystem.User.UserType;

import java.awt.print.Book;
import java.util.*;

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
        this.userService = new UserService();
    }

    public static HotelManagementService getInstance(){

        if(INSTANCE == null){
            INSTANCE = new HotelManagementService();
        }
        return INSTANCE;
    }

    public Booking bookARoom(String userID, String hotelID, String roomID, int checkInTime, PaymentStrategyEnum paymentStrategyEnum){

        Booking booking = null;
        if(userService.checkUserExistence(userID)){
            if(hotelMap.containsKey(hotelID)){
                Hotel hotel = hotelMap.get(hotelID);
                Room room = hotel.getASpecificRoom(roomID);
                if(Objects.nonNull(room)){
                    if(!room.isBookingDone()){
                        int amountNeedToBePaid = room.calculateRoomPrice();
                        User user = userService.getUser(userID);
                        if(user.getWalletMoney() >= amountNeedToBePaid){
                            user.setWalletMoney(user.getWalletMoney() - amountNeedToBePaid);
                            room.setBookingDone(true);
                            PaymentStrategy paymentStrategyToBeFollowed = PaymentStrategyFactory.getPaymentStrategy(paymentStrategyEnum);
                            paymentStrategyToBeFollowed.pay(amountNeedToBePaid);
                            System.out.println("Booking done for room : "+roomID);
                            booking = new Booking(userID,roomID,hotelID,RandomStringGenerator.generateRandomString(userID,hotelID,roomID,10),checkInTime,paymentStrategyToBeFollowed,amountNeedToBePaid, BookingStatus.BOOKED);

                            // adding booking details into in-memory db's
                            this.bookingMap.put(booking.getBookingID(), booking);
                            addBookingIntoUserMap(userID,booking.getBookingID());
                            addBookingsIntoHotel(hotelID, booking.getBookingID());
                        } else {
                            System.out.println("In sufficient wallet balance to book specified room, please recharge your wallet");
                            System.out.println("Money need to book this room : "+room.calculateRoomPrice()+" and user wallet balance : "+user.getWalletMoney());
                        }
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

        return booking;
    }

    public void cancelBooking(String bookingID){
        if(bookingMap.containsKey(bookingID)){
            Booking booking = bookingMap.get(bookingID);
            this.bookingMap.remove(bookingID);
            String userID = booking.getUserID();
            removeBookingFromHotelBooking(booking.getHotelID(),bookingID);
            removeBookingFromUserMap(userID,bookingID);
            User user = userService.getUser(userID);
            user.setWalletMoney(user.getWalletMoney() + booking.getAmountPaid());

            Hotel hotel = hotelMap.get(booking.getHotelID());
            hotel.editBookingStatusOfaSpecificRoom(booking.getRoomID(), false);
            System.out.println("Cancelled the booking");
        } else {
            System.out.println("In valid booking ID");
        }
    }

    public void removeBookingFromHotelBooking(String hotelID, String bookingID){
        if(this.hotelBookingsMap.containsKey(hotelID)){
            Map<String, Booking> bookingList = this.hotelBookingsMap.get(hotelID);
            bookingList.remove(bookingID);
        } else {
            System.out.println("No such hotel exist");
        }
    }

    public void removeBookingFromUserMap(String userId, String bookingID){
        if(this.userBookingsMap.containsKey(userId)){
            List<Booking> bookingList = this.userBookingsMap.get(userId);
            for(Booking booking : bookingList){
                if(booking.getBookingID() == bookingID){
                    booking.setBookingStatus(BookingStatus.CANCELLED);
                }
            }
        } else {
            System.out.println("No such hotel exist");
        }
    }

    public void addHotel(String hotelID,String hotelName, String userID){

        if(userService.checkUserExistence(userID)){
            User user = userService.getUser(userID);
            if(user.getUserType() == UserType.ADMIN){
                if(this.hotelMap.containsKey(hotelID)){
                    System.out.println("Already a hotel exist with such information, please use it");
                } else {
                    Hotel hotel = new Hotel(hotelID,hotelName);
                    this.hotelMap.put(hotelID,hotel);
                    Map<String, Booking> hotelBookingMap = new HashMap<>();
                    this.hotelBookingsMap.put(hotelID,hotelBookingMap);
                    System.out.println("Successfull in adding a new hotel");
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

    public void addBookingIntoUserMap(String userID, String bookingID){
        if(userBookingsMap.containsKey(userID)){
            List<Booking> bookingList = userBookingsMap.get(userID);
            bookingList.add(bookingMap.get(bookingID));
            userBookingsMap.put(userID,bookingList);
        } else {
            List<Booking> bookingList = new ArrayList<>();
            bookingList.add(bookingMap.get(bookingID));
            userBookingsMap.put(userID,bookingList);
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

    public void addRoomTypes(String hotelID, String roomID, String userID, List<RoomType> roomTypes){

        if(userService.checkUserExistence(userID)){
            User user = userService.getUser(userID);

            if(user.getUserType() == UserType.ADMIN){
                if(this.hotelMap.containsKey(hotelID)){

                    Hotel hotel = this.hotelMap.get(hotelID);
                    hotel.addRoomTypes(roomID,roomTypes);
                } else {
                    System.out.println("No such hotel exist in reservation system");
                }
            } else {
                System.out.println("You are not authorized to perform this operation");
            }
        } else {
            System.out.println("No such user exist in reservation system");
        }
    }

    public List<Room> getAvailableRooms(String hotelID){
        List<Room> availableRooms = new ArrayList<>();
        if(this.hotelMap.containsKey(hotelID)){
            Hotel hotel = hotelMap.get(hotelID);

            Map<String, Room> roomMap = hotel.getMapOfRooms();

            for(Room room : roomMap.values()){
                if(!room.isBookingDone()){
                    availableRooms.add(room);
                }
            }
        } else {
            System.out.println("No such hotel exist please use a valid one");
        }

        return availableRooms;
    }

    public void addUser(User user){
        this.userService.addUser(user);
    }

    public void removeUser(String userID){
        this.userService.removeUser(userID);
    }
}
