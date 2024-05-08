package Source_code;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserService {
    private User user; //stores the user informations who is currently logged in
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


    public boolean is_registration_successful()
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

    public void addFavoriteMovie(Movie movie) { 
        user.addFavorite(movie);
    }

    public void removeFavoriteMovie(Movie movie) {
        user.removeFavorite(movie);
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
