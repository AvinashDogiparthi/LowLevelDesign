package G_BookMyShow_V2;

import G_BookMyShow_V2.Movie.Movie;
import G_BookMyShow_V2.Movie.MovieService;
import G_BookMyShow_V2.Payment.PaymentStrategy.PaymentService;
import G_BookMyShow_V2.Payment.PaymentStrategy.PaymentStrategyEnum;
import G_BookMyShow_V2.User.User;
import G_BookMyShow_V2.User.UserService;

import java.util.List;

public class BookMyShowDemo {

    public static void main(String[] args) {
        UserService userService = new UserService();
        TheatreBookingService theatreService = new TheatreBookingService();
        MovieService movieService = new MovieService();
        PaymentService paymentService = new PaymentService();


        userService.registerUser("1449","Avinash","dogiparthi.naga@amadeus.com",1000);
        User user = userService.getUser("1449");

        movieService.addNewMovie("Kanappa","BhakthaKanappa","Mythological movie");
        Movie movie = movieService.getMovie("Kanappa");

        theatreService.addTheatre("Sri-vinakayaka","Banglore",100);
        theatreService.addShowsAndMovie("Sri-vinakayaka","430-630",movie);
        theatreService.addSeatsInMovieShow("Sri-vinakayaka","430-630",100);

        List<String> availableSeats = theatreService.getAvailableSeats("Sri-vinakayaka","430-630");
        System.out.println("BookMyShowDemo::main : available seat : "+availableSeats.size());

        String seatID = availableSeats.get(0);

        int amountPaid = theatreService.bookSeatInAShow("Sri-vinakayaka","430-630",seatID,user);
        paymentService.doPayment(PaymentStrategyEnum.UPI,amountPaid);

        List<String> availableSeatsAfterBooking = theatreService.getAvailableSeats("Sri-vinakayaka","430-630");
        System.out.println("BookMyShowDemo::main : available seat : "+availableSeatsAfterBooking.size());
    }
}
