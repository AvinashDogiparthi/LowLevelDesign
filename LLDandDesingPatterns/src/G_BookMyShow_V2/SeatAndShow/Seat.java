package G_BookMyShow_V2.SeatAndShow;

public class Seat {

    private String seatId;
    private int seatPrice;

    public Seat(String seatId, int seatPrice) {
        this.seatId = seatId;
        this.seatPrice = seatPrice;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(int seatPrice) {
        this.seatPrice = seatPrice;
    }
}
