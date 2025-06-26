package U_FlightBookingManagement;

import U_FlightBookingManagement.Flight.FlightBookingService;
import U_FlightBookingManagement.Seat.Seat;
import U_FlightBookingManagement.Seat.SeatCategoryEnum;
import U_FlightBookingManagement.User.User;
import U_FlightBookingManagement.User.UserService;

public class FlightBookingManagementDemo {

    public static void main(String[] args) {

        FlightBookingService flightBookingService = FlightBookingService.getInstance();
        UserService userService = UserService.getInstance();

        flightBookingService.establishANewFlightConnection(120, "BLR", "HYD", 2000, 3000, 4000);

        insertData(flightBookingService, 120, SeatCategoryEnum.ECONOMY);
        insertData(flightBookingService, 120, SeatCategoryEnum.PREMIUM);
        insertData(flightBookingService, 120, SeatCategoryEnum.BUSINESS);

        User user = userService.registerUser(1122,SeatCategoryEnum.ECONOMY,10000);

        Seat seat = flightBookingService.bookSeat(120,user,SeatCategoryEnum.ECONOMY);

        flightBookingService.cancelBooking(120,user,seat.getSeatID());
    }

    public static void insertData(FlightBookingService flightBookingService, int flightID, SeatCategoryEnum seatCategoryEnum){
        for(int i = 1;i<=15;i++){
            flightBookingService.addSeatInFlight(flightID,i*100 + 100,seatCategoryEnum);
        }
    }
}
