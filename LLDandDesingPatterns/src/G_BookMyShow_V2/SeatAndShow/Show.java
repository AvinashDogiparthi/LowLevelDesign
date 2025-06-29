package G_BookMyShow_V2.SeatAndShow;

import G_BookMyShow_V2.Movie.Movie;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {

    private String showID;
    private Map<String, SeatStatus> seatStatusMap;
    private Movie movie;

    public Show(String showID, Movie movie) {
        this.showID = showID;
        this.seatStatusMap = new ConcurrentHashMap<>();
        this.movie = movie;
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public Map<String, SeatStatus> getSeatStatusMap() {
        return seatStatusMap;
    }

    public void setSeatStatusMap(Map<String, SeatStatus> seatStatusMap) {
        this.seatStatusMap = seatStatusMap;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void addSeat(Seat seat){
        if(seatStatusMap.containsKey(seat.getSeatId())){
            System.out.println("Seat already exist, so updating the new one");
        } else {
            seatStatusMap.put(seat.getSeatId(),SeatStatus.AVAILABLE);
        }
    }

    public void updateSeat(String seatId,SeatStatus seatStatus){
        if(seatStatusMap.containsKey(seatId)){
            System.out.println("Updating the seat");
            seatStatusMap.put(seatId,seatStatus);
        }
    }
}
