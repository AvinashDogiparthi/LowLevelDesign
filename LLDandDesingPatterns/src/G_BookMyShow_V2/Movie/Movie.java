package G_BookMyShow_V2.Movie;

public class Movie {

    private String movieID;
    private String movieName;
    private String movieDetails;
    private int movieRating;
    private int numberOfPeopleRated;

    public Movie(String movieID, String movieName, String movieDetails) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieDetails = movieDetails;
        this.movieRating = 10;
        this.numberOfPeopleRated = 0;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(String movieDetails) {
        this.movieDetails = movieDetails;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void updateRatingWithNewRating(int movieRating){
        int numberOfPeopleRated = this.numberOfPeopleRated + 1;
        int currentRating = this.movieRating;

        int updatedRating = ( (currentRating * numberOfPeopleRated - 1 ) + movieRating ) / numberOfPeopleRated;
    }
}
