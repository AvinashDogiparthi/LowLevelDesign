package V_HotelManagementSystem;

import V_HotelManagementSystem.PaymentStrategy.PaymentStrategyEnum;
import V_HotelManagementSystem.Room.Room;
import V_HotelManagementSystem.User.User;
import V_HotelManagementSystem.User.UserBuilder;
import V_HotelManagementSystem.User.UserType;

import java.util.List;

public class HotelManagementDemo {

    public static void main(String[] args) {

        HotelManagementService hotelManagementService = HotelManagementService.getInstance();

        // admin level operations
        User adminUser = new UserBuilder()
                .withUserId("admin1")
                .withUserType(UserType.ADMIN)
                .withUserEmail("dnvavinash@gmail.com")
                .withWalletMoney(100000)
                .build();

        hotelManagementService.addUser(adminUser);
        hotelManagementService.addHotel("raddisonBlue","raddisonBlueMarathahalli", adminUser.getUserID());
        addRooms(hotelManagementService, adminUser.getUserID(), "raddisonBlue");

        List<Room> availableRooms = hotelManagementService.getAvailableRooms("raddisonBlue");
        System.out.println("Total available rooms : "+availableRooms.size());


        // customer operations
        User user1 = new UserBuilder()
                .withUserId("avinash")
                .withUserType(UserType.CUSTOMER)
                .withUserEmail("telidugurtuledumarchipoya@gmail.com")
                .withWalletMoney(100)
                .build();

        hotelManagementService.addUser(user1);
        hotelManagementService.bookARoom(user1.getUserID(),"raddisonBlue",availableRooms.get(0).getRoomID(),1, PaymentStrategyEnum.UPI_PAYMENT);
    }

    public static void addRooms(HotelManagementService hotelManagementService, String userID, String hotelID){

        for(int i = 0;i<100;i++){
            String roomID = Integer.toString(i*100+1000);
            hotelManagementService.addRoom(userID,hotelID, roomID, 100);
        }
    }
}
