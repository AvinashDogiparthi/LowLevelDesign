package G_BookMyShow_V2.Theatre;

import G_BookMyShow_V2.Movie.Movie;
import G_BookMyShow_V2.SeatAndShow.Seat;
import G_BookMyShow_V2.SeatAndShow.SeatStatus;
import G_BookMyShow_V2.SeatAndShow.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theatre {

    private String cityLocation;
    private String name;
    private Map<String, Show> shows;
    private List<Seat> listOfSeats;
    private int seatPrice;

    public Theatre(String cityLocation, String name, int seatPrice) {
        this.cityLocation = cityLocation;
        this.name = name;
        this.shows = new HashMap<>();
        this.seatPrice = seatPrice;
        this.listOfSeats = new ArrayList<>();
    }

    public List<String> getAvailableSeats(String showId){
        Show show = shows.get(showId);
        List<String> seastsList = new ArrayList<>();
        Map<String, SeatStatus> seatStatusMap = show.getSeatStatusMap();

        for(String seatID : show.getSeatStatusMap().keySet()){
            if(seatStatusMap.get(seatID) == SeatStatus.AVAILABLE){
                seastsList.add(seatID);
            }
        }

        return seastsList;
    }

    public int bookSeatInAShow(String showID, String seatID){
        Show show = shows.get(showID);
        Map<String, SeatStatus> seatStatusMap = show.getSeatStatusMap();
        int seatBookingPrice = 0;

        for(String iterableSeatID : show.getSeatStatusMap().keySet()){
            if(seatStatusMap.get(seatID) == SeatStatus.AVAILABLE){
                seatStatusMap.put(seatID,SeatStatus.NOT_AVAILABLE);
                seatBookingPrice = seatPrice;
                System.out.println("Theatre::bookSeatInAShow -- seat is available, so booking is done for the seat");
            }
        }

        return seatBookingPrice;
    }

    public int cancelBookingSeatInAShow(String showID, String seatID){
        Show show = shows.get(showID);
        Map<String, SeatStatus> seatStatusMap = show.getSeatStatusMap();
        int seatBookingPrice = 0;

        for(String iterableSeatID : show.getSeatStatusMap().keySet()){
            if(seatStatusMap.get(seatID) == SeatStatus.NOT_AVAILABLE){
                seatStatusMap.put(seatID,SeatStatus.AVAILABLE);
                seatBookingPrice = 0;
                System.out.println("Theatre::bookSeatInAShow -- seat is available, so booking is done for the seat");
            } else {
                System.out.println("Theatre::bookSeatInAShow -- seat is not available, so pick one seat which is available");
            }
        }

        return seatBookingPrice;
    }

    public void addShowsAndMovie(String showId, Movie movie){
        if(shows.containsKey(showId)){
            System.out.println("Theatre:addShowsAndMovie -- show already exist so updating the show");
            Show show = shows.get(showId);
            show.setMovie(movie);
        } else {
            System.out.println("Theatre:addShowsAndMovie -- creating a new show");
            Show show = new Show(showId,movie);
            shows.put(showId,show);
        }
    }

    public void addSeatsInShowsAndMovie(String showId, int numberOfSeats){
        if(shows.containsKey(showId)){
            Show show = shows.get(showId);
            addSeatsInMovieShow(show.getShowID(),numberOfSeats);
        }
    }

    public void addSeatsInMovieShow(String showId, int numberOfSeats ){
        if(shows.containsKey(showId)){
            Show show = shows.get(showId);
            System.out.println("Theatre::addSeatsInMovieShow -- adding "+ numberOfSeats+" seats in show");
            for(int i = 0;i<numberOfSeats;i++){
                Seat seat = new Seat(Integer.toString(i*10+1000), this.seatPrice);
                show.addSeat(seat);
                listOfSeats.add(seat);
            }
        }
    }

    public void removeSeatsFromMovieShow(String showId, String seatId){
        if(shows.containsKey(showId)){
            Show show = shows.get(showId);
            Map<String, SeatStatus> seatStatusMap = show.getSeatStatusMap();
            seatStatusMap.remove(seatId);
        }
    }
    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Show> getShows() {
        return shows;
    }

    public void setShows(Map<String, Show> shows) {
        this.shows = shows;
    }

    public List<Seat> getListOfSeats() {
        return listOfSeats;
    }

    public void setListOfSeats(List<Seat> listOfSeats) {
        this.listOfSeats = listOfSeats;
    }
}
