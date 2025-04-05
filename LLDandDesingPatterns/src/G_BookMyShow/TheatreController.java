package G_BookMyShow;

import G_BookMyShow.Enum.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatreMap;
    List<Theatre> allTheatres;

    public void addTheatre(City city, Theatre theatre){
        allTheatres.add(theatre);

        List<Theatre> theatres = cityVsTheatreMap.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatreMap.put(city,theatres);
    }

    public Map<Theatre, List<Show>> getAllShows(City city, Movie movie){
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatreMap.getOrDefault(city, new ArrayList<>());

        if(!theatres.isEmpty()){
            for(Theatre theatre : theatres){
                List<Show> shows = theatre.getShows();
                List<Show> givenShows = new ArrayList<>();
                for(Show show : shows){
                    if(show.getMovie().equals(movie)){
                        givenShows.add(show);
                    }
                }
                if(!givenShows.isEmpty()){
                    theatreVsShows.put(theatre,givenShows);
                }
            }
        }
        return theatreVsShows;
    }

}
