package Source_code;
import java.util.Set;
import java.util.TreeSet;


//This class encapsulates the information of a user
public class User {
    private String email;
    private Set<Movie> favorites; //stores the favorite movies of the user
    

    public User(String email) {
        this.email = email;
        this.favorites = new TreeSet<>();
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addFavorite(Movie movie) {
        favorites.add(new Movie(movie.getTitle(), movie.getCast(), movie.getCategory(), movie.getReleaseDate(), movie.getBudget()));
    }

    //this methid checks if the movie is in the favorites list
    public boolean isMovieInFavorites(String movieTitle)
    {
        for(Movie movie : favorites) {
            if(movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return true;
            }
        }
        return false;
    }

    //this method returns the detailed information of the movie if it is in the favorites list
    public String SearchFavouriteMovie(String movieTitle)
    {
        for(Movie movie : favorites) {
            if(movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return movie.getDetails();
            }
        }
        return "Movie is not found in the favorites";
    }

    public void removeFavorite(Movie movie) {
        favorites.remove(movie);
    }

    public Set<Movie> getFavorites() {
        return new TreeSet<>(favorites);
    }


}






