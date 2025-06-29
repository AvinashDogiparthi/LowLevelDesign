package G_BookMyShow_V2;

import G_BookMyShow_V2.Booking.Booking;
import G_BookMyShow_V2.Movie.Movie;
import G_BookMyShow_V2.Payment.PaymentStrategy.PaymentService;
import G_BookMyShow_V2.Payment.PaymentStrategy.PaymentStrategy;
import G_BookMyShow_V2.Payment.PaymentStrategy.PaymentStrategyEnum;
import G_BookMyShow_V2.SeatAndShow.Show;
import G_BookMyShow_V2.Theatre.Theatre;
import G_BookMyShow_V2.User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreBookingService {

    // movie , theatre map
    private Map<String, Map<String, Theatre>> movieVsTheatreMap;
    private Map<String, Theatre> theatreMap;
    private PaymentService paymentService;

    public TheatreBookingService() {
        this.movieVsTheatreMap = new HashMap<>();
        this.theatreMap = new HashMap<>();
    }

    public Map<Theatre, Map<String, Show>> getAvailableShowsAndTheatresMap(String cityName, Movie movie){

        Map<Theatre, Map<String, Show>> availableShowsAndTheatresMap = new HashMap<>();
        Map<String, Theatre> theatreMap1 = movieVsTheatreMap.get(movie.getMovieID());

        for(Theatre iterableTheatre : theatreMap1.values()){
            if(iterableTheatre.getCityLocation() == cityName){
                Map<String, Show> availableShows = iterableTheatre.getShows();
                Map<String, Show> exactMovieMatchShows = new HashMap<>();
                for(Show show : availableShows.values()){
                    if(show.getMovie() == movie){
                        exactMovieMatchShows.put(show.getShowID(), show);
                    }
                }

                availableShowsAndTheatresMap.put(iterableTheatre, exactMovieMatchShows);
            }
        }
        return availableShowsAndTheatresMap;
    }

    public Map<String, Theatre> getTheatresAvailableForMovieInCity(String city, String movieID) {
        if (movieVsTheatreMap.containsKey(movieID)) {
            Map<String, Theatre> theatreMap = movieVsTheatreMap.get(movieID);
            return theatreMap.entrySet().stream()
                    .filter(entry -> city.equals(entry.getValue().getCityLocation()))
                    .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
        }
        return new HashMap<>();
    }

    public void addTheatre(String theatreName, String cityName, int seatPrice) {
        Theatre theatre = new Theatre(cityName, theatreName, seatPrice);
        theatreMap.put(theatreName, theatre);
    }

    public void removeTheatre(String theatreName) {
        theatreMap.remove(theatreName);
    }

    public List<String> getAvailableSeats(String theatreName, String showId) {
        if (theatreMap.containsKey(theatreName)) {
            Theatre theatre = theatreMap.get(theatreName);
            return theatre.getAvailableSeats(showId);
        }
        return new ArrayList<>();
    }

    public int bookSeatInAShow(String theatreName, String showID, String seatID, User user) {
        int amountPaid = 0;
        if (theatreMap.containsKey(theatreName)) {
            Theatre theatre = theatreMap.get(theatreName);
            amountPaid = theatre.bookSeatInAShow(showID, seatID);
            if (amountPaid > 0) {
                Booking booking = new Booking(RandomStringUtil.generateRandomStringWithUserId(user.getUserId(),10), theatreName, showID, seatID, amountPaid);
                user.addBooking(booking);
                System.out.println("TheatreBookingService::bookSeatInAShow -- Booking successful for user: " + user.getUserName());
            } else {
                System.out.println("TheatreBookingService::bookSeatInAShow -- Seat booking failed for user: " + user.getUserName());
            }
        } else {
            System.out.println("TheatreBookingService::bookSeatInAShow -- Theatre not found: " + theatreName);
        }
        return amountPaid;
    }

    public void addShowsAndMovie(String theatreName, String showId, Movie movie) {
        if (theatreMap.containsKey(theatreName)) {
            Theatre theatre = theatreMap.get(theatreName);
            theatre.addShowsAndMovie(showId, movie);
        }
    }

    public void addSeatsInShowsAndMovie(String theatreName, String showId, int numberOfSeats) {
        if (theatreMap.containsKey(theatreName)) {
            Theatre theatre = theatreMap.get(theatreName);
            theatre.addSeatsInShowsAndMovie(showId, numberOfSeats);
        }
    }

    public void addSeatsInMovieShow(String theatreName, String showId, int numberOfSeats) {
        if (theatreMap.containsKey(theatreName)) {
            Theatre theatre = theatreMap.get(theatreName);
            theatre.addSeatsInMovieShow(showId, numberOfSeats);
        }
    }

    public void removeSeatsFromMovieShow(String theatreName, String showId, String seatId) {
        if (theatreMap.containsKey(theatreName)) {
            Theatre theatre = theatreMap.get(theatreName);
            theatre.removeSeatsFromMovieShow(showId, seatId);
        }
    }

    public void bookSeat(String seatId, String showID, String movieId, String theatreID){
        Map<String, Theatre> availablTheatres = this.movieVsTheatreMap.get(movieId);
        Theatre theatre = availablTheatres.get(theatreID);
        theatre.bookSeatInAShow(showID, seatId);
    }

    public int cancelSeatBooking(String seatId, String showId,String movieID, String theatreID){
        Map<String, Theatre> availableTheatres = this.movieVsTheatreMap.get(movieID);
        Theatre theatre = availableTheatres.get(theatreID);
        return theatre.cancelBookingSeatInAShow(showId, seatId);
    }
}