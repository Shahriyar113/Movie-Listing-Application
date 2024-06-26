package Source_code.Core_code;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserService {
    //stores the user informations who is currently logged in
    private User user; 
    //regex for email pattern
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    public UserService() {
        this.user = null;
    }

    public UserService(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    //this method checks if the email is valid or not
    public boolean isRegistrationSuccessful()
    {
        String email = user.getEmail();

        if(email == null) {
            return false;
        }
        //assuming highest acceptable length of email is 50
        //assuming lowest acceptable length of email is 10 [as "@gmail.com" is 10 characters]
        else if(email.length() < 10 || email.length() > 50) {
            return false;
        }
        else if(!EMAIL_PATTERN.matcher(email).matches()) {
            return false;
        }
        else {
               return true;
          }
    }

    public String addFavoriteMovie(Movie movie) { 
        //if the movie is already in the favorites list, then return a message
        if(user.isMovieInFavorites(movie.getTitle())) {
            return "Movie is already in the favorites";
        }

        user.addFavorite(movie);
        return "Movie added to favorites";
    }

    public String removeFavoriteMovie(String movieTitle) {
        //if the movie is not in the favorites list, then return a message
        if(!user.isMovieInFavorites(movieTitle)) {
            return "Movie is not in the favorites";
        }

        Set<Movie> favorites = user.getFavorites();
        for(Movie movie : favorites) {
            if(movie.getTitle().equalsIgnoreCase(movieTitle)) {
                user.removeFavorite(movie);
                return "Movie removed from favorites";
            }
        }

        return "Movie is not in the favorites";
    }

    public boolean isMovieInFavorites(String movieTitle)
    {
        return user.isMovieInFavorites(movieTitle);
    }

    public String getUserDetails()
    {
        Set<Movie> favoriteMovies = user.getFavorites();
        List<String> favoriteMoviesTitles = new ArrayList<>();
        for(Movie movie : favoriteMovies) {
            favoriteMoviesTitles.add(movie.getTitle());
        }
;
        return "email: " + user.getEmail() + "\n" +
               "FavoriteMovies: " + favoriteMoviesTitles.toString();
        
    }

    //the input of this method will be the title of a "movie" and it will return the detailed information of the movie 
    //if the movie is in the favorites list of the user
    public String SearchMovieByTitleAmongFavorites(String movieTitle)
    {
        return user.SearchFavouriteMovie(movieTitle);
    }






    
}
