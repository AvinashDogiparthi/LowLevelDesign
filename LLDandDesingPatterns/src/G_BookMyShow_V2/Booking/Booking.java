package G_BookMyShow_V2.Booking;

import G_BookMyShow_V2.Payment.PaymentStrategy.PaymentStrategy;

public class Booking {

    private String bookingID;
    private String theatreID;
    private String cityID;
    private String showID;
    private int amountPaid;

    public Booking(String bookingID, String theatreID, String cityID, String showID, int amountPaid) {
        this.bookingID = bookingID;
        this.theatreID = theatreID;
        this.cityID = cityID;
        this.showID = showID;
        this.amountPaid = amountPaid;
    }

    public String getTheatreID() {
        return theatreID;
    }

    public void setTheatreID(String theatreID) {
        this.theatreID = theatreID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
