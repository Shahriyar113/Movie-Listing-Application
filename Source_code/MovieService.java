package Source_code;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class MovieService {
    private Set<Movie> movies;

    public MovieService() {
        //this treeset will store the movies in sorted order of their titles
        this.movies = new TreeSet<>();
    }   

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    
    }

    public Movie searchMoviesByTitle(String title) {

        //Assuming each movie has its unique title
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
               return movie;
            }
        }
        return new nullMovie();
    }

    public List<Movie> searchMoviesByCast(String castMember) {
        List<Movie> moviesByCast = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCast().contains(castMember)) {
                moviesByCast.add(movie);
            }
        }
        return moviesByCast;
    }

    public List<Movie> searchMoviesByCategory(String category) {
        List<Movie> moviesByCategory = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCategory().equalsIgnoreCase(category)) {
                moviesByCategory.add(movie);
            }
        }
        return moviesByCategory;
    }


    public String getMovieDetails(Movie movie) {

        return movie.getDetails();
       
    }

    
}
