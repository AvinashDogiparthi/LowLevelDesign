package U_FlightBookingManagement.Flight;

public class FlightBuilder {

    public int flightID;
    public String originStation;
    public String destinationStation;
    public int economySeatPrice;
    public int businessSeatPrice;
    public int premiumSeatPrice;

    public FlightBuilder withFlightId(int flightID){
        this.flightID = flightID;
        return this;
    }

    public FlightBuilder withOrigin(String originStation){
        this.originStation = originStation;
        return this;
    }

    public FlightBuilder withDestination(String destinationStation){
        this.destinationStation = destinationStation;
        return this;
    }

    public FlightBuilder withEconomySeatPrice(int economySeatPrice){
        this.economySeatPrice = economySeatPrice;
        return this;
    }

    public FlightBuilder withBusinessSeatPrice(int businessSeatPrice){
        this.businessSeatPrice = businessSeatPrice;
        return this;
    }

    public FlightBuilder withPremiumSeatPrice(int premiumSeatPrice){
        this.premiumSeatPrice = premiumSeatPrice;
        return this;
    }

    public Flight build(){
        return new Flight(this);
    }
}
