package Source_code;
import java.util.Set;
import java.util.TreeSet;

public class User {
    private String email;
    private Set<Movie> favorites;
    

    public User(String email) {
        this.email = email;
        this.favorites = new TreeSet<>();
    }

    // Methods to add, remove favorites, and other getters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addFavorite(Movie movie) {
        favorites.add(new Movie(movie.getTitle(), movie.getCast(), movie.getCategory(), movie.getRelease_date(), movie.getBudget()));
    }

    public boolean isMovieInFavorites(String movieTitle)
    {
        for(Movie movie : favorites) {
            if(movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return true;
            }
        }
        return false;
    }

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






