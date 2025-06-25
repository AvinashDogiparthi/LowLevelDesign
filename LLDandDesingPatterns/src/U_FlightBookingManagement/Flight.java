package U_FlightBookingManagement;
import java.util.*;

public class Flight {

    private int flightID;
    private String originStation;
    private String destinationStation;
    private Map<Integer, Seat> availableSeatMap;
    private int availableSeatsCount;

    private int availableEconomySeats;
    private int availableBussinessSeats;
    private int availablePremiumSeats;

    private Map<String,Integer> seatCategoryVsPriceMap;
    private Map<String, List<Seat>> seatCategoryVsSeatMap;

    public Flight(FlightBuilder flightBuilder){
        this.flightID = flightBuilder.flightID;
        this.originStation = flightBuilder.originStation;
        this.destinationStation = flightBuilder.destinationStation;

        // not configuring seats at the time of flight creation
        // user can add seats once he instantiates Flight Object
        this.availableSeatsCount = 0;
        this.availableSeatMap = new HashMap<>();
        this.availableEconomySeats = 0;
        this.availableBussinessSeats = 0;
        this.availablePremiumSeats = 0;

        this.seatCategoryVsPriceMap = new HashMap<>();
        this.seatCategoryVsSeatMap = new HashMap<>();

        seatCategoryVsPriceMap.put("BUSINESS",flightBuilder.businessSeatPrice);
        seatCategoryVsPriceMap.put("ECONOMY",flightBuilder.economySeatPrice);
        seatCategoryVsPriceMap.put("PREMIUM",flightBuilder.premiumSeatPrice);

        seatCategoryVsSeatMap.put("BUSINESS",new ArrayList<>());
        seatCategoryVsSeatMap.put("ECONOMY",new ArrayList<>());
        seatCategoryVsSeatMap.put("PREMIUM",new ArrayList<>());
    }

    public void addSeat(int seatID, SeatCategoryEnum seatCategoryEnum){
        Seat seat= null;

        if(seatCategoryEnum == SeatCategoryEnum.ECONOMY){
            seat = new Seat(seatID,seatCategoryEnum,seatCategoryVsPriceMap.get("ECONOMY"));
            this.availableSeatMap.put(seatID,seat);
            List<Seat> currentSeatMap = this.seatCategoryVsSeatMap.get("ECONOMY");
            currentSeatMap.add(seat);
            this.seatCategoryVsSeatMap.put("ECONOMY",currentSeatMap);
            this.availableEconomySeats += 1;
            this.availableSeatsCount += 1;
            System.out.println("Flight::addSeat --- SUCCESSFULL in creation of ECONOMY SEAT");
        } else if (seatCategoryEnum == SeatCategoryEnum.BUSINESS){
            seat = new Seat(seatID,seatCategoryEnum,seatCategoryVsPriceMap.get("BUSINESS"));
            List<Seat> currentSeatMap = this.seatCategoryVsSeatMap.get("BUSINESS");
            currentSeatMap.add(seat);
            this.seatCategoryVsSeatMap.put("BUSINESS",currentSeatMap);
            this.availableSeatMap.put(seatID,seat);
            this.availableBussinessSeats += 1;
            this.availableSeatsCount += 1;
            System.out.println("Flight::addSeat --- SUCCESSFULL in creation of BUSINESS SEAT");
        } else if (seatCategoryEnum == SeatCategoryEnum.PREMIUM){
            seat = new Seat(seatID,seatCategoryEnum,seatCategoryVsPriceMap.get("PREMIUM"));
            List<Seat> currentSeatMap = this.seatCategoryVsSeatMap.get("PREMIUM");
            currentSeatMap.add(seat);
            this.seatCategoryVsSeatMap.put("PREMIUM",currentSeatMap);
            this.availableSeatMap.put(seatID,seat);
            this.availablePremiumSeats += 1;
            this.availableSeatsCount += 1;
            System.out.println("Flight::addSeat --- SUCCESSFULL in creation of PREMIUM SEAT");
        } else {
            System.out.println("Flight::addSeat --- provided seat category doesn't exist in current system");
        }
    }

    public void bookSeat(SeatCategoryEnum seatCategoryEnum, User user){
        if(seatCategoryEnum == SeatCategoryEnum.ECONOMY && seatCategoryVsSeatMap.containsKey("ECONOMY")){
            List<Seat> seatsLeft = seatCategoryVsSeatMap.get("ECONOMY");

            Seat seat = null;

            for(Seat iterableSeat : seatsLeft){
                if(Objects.isNull(seat)){
                    seat = iterableSeat;
                }
            }

            seat.setBooked(true);
            seat.setSeatOwner(user);


            this.availableSeatMap.remove(seat.getSeatID());
            this.availableEconomySeats -= 1;
            System.out.println("Flight::bookSeat --- BOOKING is done");
        } else if (seatCategoryEnum == SeatCategoryEnum.ECONOMY && seatCategoryVsSeatMap.containsKey("BUSINESS")){
            List<Seat> seatsLeft = seatCategoryVsSeatMap.get("BUSINESS");

            Seat seat = null;

            for(Seat iterableSeat : seatsLeft){
                if(Objects.isNull(seat)){
                    seat = iterableSeat;
                }
            }

            seat.setBooked(true);
            seat.setSeatOwner(user);


            this.availableSeatMap.remove(seat.getSeatID());
            this.availableBussinessSeats -= 1;
            System.out.println("Flight::bookSeat --- BOOKING is done");
        } else if (seatCategoryEnum == SeatCategoryEnum.PREMIUM && seatCategoryVsSeatMap.containsKey("PREMIUM")){
            List<Seat> seatsLeft = seatCategoryVsSeatMap.get("PREMIUM");

            Seat seat = null;

            for(Seat iterableSeat : seatsLeft){
                if(Objects.isNull(seat)){
                    seat = iterableSeat;
                }
            }

            seat.setBooked(true);
            seat.setSeatOwner(user);


            this.availableSeatMap.remove(seat.getSeatID());
            this.availableSeatsCount -= 1;
            System.out.println("Flight::bookSeat --- BOOKING is done");
        } else {
            System.out.println("Flight::bookSeat --- INCORRECT seat category please use available seat categories for this flight");
        }
    }

    public void removeSeat(int seatID){
        if(availableSeatMap.containsKey(seatID)) {

            Seat seat = availableSeatMap.get(seatID);
            this.availableSeatsCount -= 1;
            reduceRespectiveSeatsCount(seat);
            availableSeatMap.remove(seatID);

        } else {
            System.out.println("Flight::removeSeat --- no such seat exist to remove");
        }
    }

    private void reduceRespectiveSeatsCount(Seat seat) {
        if(seat.getSeatCategoryEnum() == SeatCategoryEnum.ECONOMY){
            this.availableEconomySeats -= 1;
        } else if (seat.getSeatCategoryEnum() == SeatCategoryEnum.BUSINESS){
            this.availableBussinessSeats -= 1;
        } else {
            this.availablePremiumSeats -= 1;
        }
    }

    public void increaseBusinessPrice(int requestedAmount){
        this.seatCategoryVsPriceMap.put("BUSINESS",requestedAmount);
    }

    public void increaseEconomyPrice(int requestedAmount){
        this.seatCategoryVsPriceMap.put("ECONOMY",requestedAmount);
    }

    public void increasePremiumPrice(int requestedAmount){
        this.seatCategoryVsPriceMap.put("PREMIUM",requestedAmount);
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getOriginStation() {
        return originStation;
    }

    public void setOriginStation(String originStation) {
        this.originStation = originStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Map<Integer, Seat> getAvailableSeatMap() {
        return availableSeatMap;
    }

    public void setAvailableSeatMap(Map<Integer, Seat> availableSeatMap) {
        this.availableSeatMap = availableSeatMap;
    }

    public int getAvailableSeatsCount() {
        return availableSeatsCount;
    }

    public void setAvailableSeatsCount(int availableSeatsCount) {
        this.availableSeatsCount = availableSeatsCount;
    }

    public int getAvailableEconomySeats() {
        return availableEconomySeats;
    }

    public void setAvailableEconomySeats(int availableEconomySeats) {
        this.availableEconomySeats = availableEconomySeats;
    }

    public int getAvailableBussinessSeats() {
        return availableBussinessSeats;
    }

    public void setAvailableBussinessSeats(int availableBussinessSeats) {
        this.availableBussinessSeats = availableBussinessSeats;
    }

    public int getAvailablePremiumSeats() {
        return availablePremiumSeats;
    }

    public void setAvailablePremiumSeats(int availablePremiumSeats) {
        this.availablePremiumSeats = availablePremiumSeats;
    }
}
