package U_FlightBookingManagement.Flight;

import U_FlightBookingManagement.Seat.SeatCategoryEnum;
import U_FlightBookingManagement.User.User;
import U_FlightBookingManagement.Seat.Seat;

import java.util.HashMap;
import java.util.Map;

public class FlightBookingService {

    private static FlightBookingService instance = null;
    private Map<Integer, Flight> flightMap;

    private FlightBookingService(){
        flightMap = new HashMap<>();
    }

    public static synchronized FlightBookingService getInstance(){
        if(instance == null){
            instance = new FlightBookingService();
        }
        return instance;
    }


    public void establishANewFlightConnection(int flightID, String originStation, String destinationStation, int economySeatPrice, int businessSeatPrice,  int premiumSeatPrice){

        if(!flightMap.containsKey(flightID)){
            Flight flight = new FlightBuilder()
                    .withFlightId(flightID)
                    .withOrigin(originStation)
                    .withDestination(destinationStation)
                    .withEconomySeatPrice(economySeatPrice)
                    .withBusinessSeatPrice(businessSeatPrice)
                    .withPremiumSeatPrice(premiumSeatPrice)
                    .build();

            flightMap.put(flightID,flight);
            System.out.println("FlightBookingSystem::establishANewFlightConnection -- SUCCESSFUL in creating a new flight");
        }
    }

    public void addSeatInFlight(int flightID, int seatID, SeatCategoryEnum seatCategoryEnum){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.addSeat(seatID, seatCategoryEnum);
        }
    }

    public void removeSeatFromFlight(int flightID, int seatID){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.removeSeat(seatID);
        }
    }

    public Seat bookSeat(int flightId, User user, SeatCategoryEnum seatCategoryEnum){

        Seat seat = null;
        if(flightMap.containsKey(flightId)){
            Flight flight = flightMap.get(flightId);
            seat = flight.bookSeat(seatCategoryEnum, user);
        }
        return seat;
    }

    public void cancelBooking(int flightId, User user, int seatID){

        if(flightMap.containsKey(flightId)){
            Flight flight = flightMap.get(flightId);
            flight.cancelBookedSeat(user, seatID);
        }
    }

    public void updateFlightOriginStation(int flightID, String originStation){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.setOriginStation(originStation);
        }
    }

    public void updateFlightDestinationStation(int flightID, String destinationStation){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.setOriginStation(destinationStation);
        }
    }

    public void updateEconomySeatPrice(int flightID, int economySeatPrice){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.updateEconomySeatPrice(economySeatPrice);
        }
    }

    public void updateBusinessSeatPrice(int flightID, int businessSeatPrice){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.updateBusinessSeatPrice(businessSeatPrice);
        }
    }

    public void updatePremiumSeatPrice(int flightID, int premiumSeatPrice){

        if(flightMap.containsKey(flightID)){
            Flight flight = flightMap.get(flightID);
            flight.updatePremimumSeatPrice(premiumSeatPrice);
        }
    }

}
