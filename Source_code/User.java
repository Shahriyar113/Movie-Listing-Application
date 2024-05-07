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
        favorites.add(movie);
    }

    public void removeFavorite(Movie movie) {
        favorites.remove(movie);
    }

    public Set<Movie> getFavorites() {
        return new TreeSet<>(favorites);
    }


}






