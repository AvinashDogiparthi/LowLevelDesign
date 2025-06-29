package G_BookMyShow_V2.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieService {

    private Map<String, Movie> movieMap;

    public MovieService() {
        this.movieMap = new HashMap<>();
    }

    public void addNewMovie(String movieID, String movieName, String movieDescription){
        if(!movieMap.containsKey(movieID)){
            Movie movie = new Movie(movieID,movieName,movieDescription);
            this.movieMap.put(movieID,movie);
            System.out.println("MovieService::addNewMovie -- SUCESSFULL in adding a new movie");
        } else {
            System.out.println("MovieService::addNewMovie -- registering a new movie with provided details");
        }
    }

    public void removeMovie(String movieID){
        if(movieMap.containsKey(movieID)){
            this.movieMap.remove(movieID);
            System.out.println("MovieService::removeMovie -- removed movie from BMS system");
        } else {
            System.out.println("MovieService::removeMovie --- no movie with "+ movieID+" exists in BMS system");
        }
    }

    public Map<String, Movie> getTop10Movies() {
        return movieMap.values().stream()
                .sorted((m1, m2) -> Integer.compare(m2.getMovieRating(), m1.getMovieRating()))
                .limit(10) // Limit to top 10 movies
                .collect(HashMap::new, (map, movie) -> map.put(movie.getMovieID(), movie), Map::putAll);
    }

    public void rateMovie(String movieID, int movieRating){
        Movie movie = movieMap.get(movieID);
        movie.updateRatingWithNewRating(movieRating);
        System.out.println("MovieService::rateMovie -- updated movie rating by averaging the user sent rating");
    }

    public Movie getMovie(String movieID){
        return this.movieMap.get(movieID);
    }
}
