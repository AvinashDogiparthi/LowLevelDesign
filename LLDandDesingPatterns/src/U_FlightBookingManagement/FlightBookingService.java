package U_FlightBookingManagement;

import java.util.HashMap;
import java.util.Map;

public class FlightBookingService {

    private static FlightBookingService instance = null;
    private Map<Integer,Flight> flightMap;

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

}
