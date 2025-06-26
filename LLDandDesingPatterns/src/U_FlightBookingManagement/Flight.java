package U_FlightBookingManagement;
import U_FlightBookingManagement.NotificationStrategy.utils.NotificationBuilder;
import U_FlightBookingManagement.NotificationStrategy.utils.NotificationDetails;
import U_FlightBookingManagement.NotificationStrategy.NotificationStrategy;
import U_FlightBookingManagement.NotificationStrategy.utils.NotificationStrategyFactory;

import java.util.*;

public class Flight {

    private int flightID;
    private String originStation;
    private String destinationStation;
    private Map<Integer, Seat> availableSeatMap;
    private Map<Integer, Seat> bookedSeatMap;
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
        this.bookedSeatMap = new HashMap<>();
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

            if(seatCategoryVsPriceMap.get("ECONOMY")<user.getWalletMoney()){
                seat.setBooked(true);
                seat.setSeatOwner(user);
                user.setWalletMoney(user.getWalletMoney()-seatCategoryVsPriceMap.get("ECONOMY"));
            } else {
                System.out.println("Flight::bookSeat --- user doesnt have enough wallet cash to purchase any seat selected category");
            }


            this.availableSeatMap.remove(seat.getSeatID());
            this.availableEconomySeats -= 1;
            this.bookedSeatMap.put(seat.getSeatID(),seat);
            System.out.println("Flight::bookSeat --- BOOKING is done");
            processNotificationForBooking(user, seat);
        } else if (seatCategoryEnum == SeatCategoryEnum.ECONOMY && seatCategoryVsSeatMap.containsKey("BUSINESS")){
            List<Seat> seatsLeft = seatCategoryVsSeatMap.get("BUSINESS");

            Seat seat = null;

            for(Seat iterableSeat : seatsLeft){
                if(Objects.isNull(seat)){
                    seat = iterableSeat;
                }
            }

            if(seatCategoryVsPriceMap.get("BUSINESS")<user.getWalletMoney()){
                seat.setBooked(true);
                seat.setSeatOwner(user);
                user.setWalletMoney(user.getWalletMoney()-seatCategoryVsPriceMap.get("BUSINESS"));
            } else {
                System.out.println("Flight::bookSeat --- user doesnt have enough wallet cash to purchase any seat selected category");
            }


            this.availableSeatMap.remove(seat.getSeatID());
            this.availableBussinessSeats -= 1;
            this.bookedSeatMap.put(seat.getSeatID(),seat);
            System.out.println("Flight::bookSeat --- BOOKING is done");
            processNotificationForBooking(user, seat);
        } else if (seatCategoryEnum == SeatCategoryEnum.PREMIUM && seatCategoryVsSeatMap.containsKey("PREMIUM")){
            List<Seat> seatsLeft = seatCategoryVsSeatMap.get("PREMIUM");

            Seat seat = null;

            for(Seat iterableSeat : seatsLeft){
                if(Objects.isNull(seat)){
                    seat = iterableSeat;
                }
            }

            if(seatCategoryVsPriceMap.get("PREMIUM")<user.getWalletMoney()){
                seat.setBooked(true);
                seat.setSeatOwner(user);
                user.setWalletMoney(user.getWalletMoney()-seatCategoryVsPriceMap.get("PREMIUM"));
            } else {
                System.out.println("Flight::bookSeat --- user doesnt have enough wallet cash to purchase any seat selected category");
            }


            this.availableSeatMap.remove(seat.getSeatID());
            this.availableSeatsCount -= 1;
            this.bookedSeatMap.put(seat.getSeatID(),seat);
            System.out.println("Flight::bookSeat --- BOOKING is done");
            processNotificationForBooking(user, seat);
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

    public void cancelBookedSeat(User user, Seat seatID){

        if(bookedSeatMap.containsKey(seatID)){
            Seat seat = bookedSeatMap.get(seatID);

            String seatCategory = findSeatCategory(seat);

            if(Objects.nonNull(seatCategory)){

                if(seat.getSeatOwner().getUserID() == user.getUserID()){
                    seat.setBooked(false);
                    seat.setSeatOwner(null);
                    user.setWalletMoney(user.getWalletMoney() + seatCategoryVsPriceMap.get(seatCategory));
                    processNotificationForCancelling(user, seat);
                } else {
                    System.out.println("Flight::cancelBookedSeat -- user is not authorized to cancel as booking was not done by him");
                }
            } else {
                System.out.println("Flight::cancelBookedSeat --- no such seat category exist");
            }
        } else {
            System.out.println("Flight::cancelBookedSeat --- registration itself has not been done for this seat, please cross check seat ID again");
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

    private static void processNotificationForBooking(User user, Seat seat) {
        NotificationDetails notificationDetails = new NotificationBuilder()
                .withUserID(user.getUserID())
                .withBookingStatus(true)
                .withSeatCategoryEnum(seat.getSeatCategoryEnum())
                .build();
        NotificationStrategy notificationStrategy = NotificationStrategyFactory.getNotificationStrategy(user.getNotificationStrategyEnum());
        notificationStrategy.notify(user,notificationDetails);
    }

    private static void processNotificationForCancelling(User user, Seat seat) {
        NotificationDetails notificationDetails = new NotificationBuilder()
                .withUserID(user.getUserID())
                .withCancellationStatus(true)
                .withSeatCategoryEnum(seat.getSeatCategoryEnum())
                .build();
        NotificationStrategy notificationStrategy = NotificationStrategyFactory.getNotificationStrategy(user.getNotificationStrategyEnum());
        notificationStrategy.notify(user,notificationDetails);
    }

    private String findSeatCategory(Seat seat) {
        String seatCategory = null;
        if(seat.getSeatCategoryEnum() == SeatCategoryEnum.ECONOMY){
            seatCategory = "ECONOMY";
        } else if (seat.getSeatCategoryEnum() == SeatCategoryEnum.BUSINESS){
            seatCategory = "BUSINESS";
        } else if (seat.getSeatCategoryEnum() == SeatCategoryEnum.PREMIUM){
            seatCategory = "PREMIUM";
        }
        return seatCategory;
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
