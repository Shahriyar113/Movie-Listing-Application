package Source_code.Core_code;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class MovieService {
    private Set<Movie> movies;

    public MovieService() {
        //"TreeSet" is used as it will store the movies in sorted order of their titles
        this.movies = new TreeSet<Movie>();
    }   

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    public Movie searchMoviesByTitle(String title) {

        //Assuming each movie has a unique title
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
               return movie;
            }
        }

    
        return new NullMovie();
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
