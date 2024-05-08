// import static org.junit.Assert.*;
// import org.junit.Before;
// import org.junit.Test;
package Source_code;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        this.userService = new UserService();
    }


    @Test
    public void testUserRegistration_1() {

        User newUser = new User("user123@example.com");
        userService.setUser(newUser);
        assertTrue(userService.isRegistrationSuccessful());
    }

    @Test
    public void testUserRegistration_2() {
        User newUser = new User("@example.com");
        userService.setUser(newUser);
        assertFalse(userService.isRegistrationSuccessful());
    }

    @Test
    public void testUserRegistration_3() {
        User newUser = new User(null);
        userService.setUser(newUser);
        assertFalse(userService.isRegistrationSuccessful());
    }
    @Test
    public void testUserRegistration_4() {
        User newUser = new User("abcd");
        userService.setUser(newUser);
        assertFalse(userService.isRegistrationSuccessful());
    }

    @Test
    public void testAddFavoriteMovie() {
        User user = new User("user@example.com");
        userService.setUser(user);
        Movie newMovie = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000);
        String succesfullyAddedMsg = userService.addFavoriteMovie(newMovie);
        assertTrue(userService.getUser().getFavorites().contains(newMovie) && succesfullyAddedMsg.equalsIgnoreCase("Movie added to favorites"));
        String alreadyInFavMsg = userService.addFavoriteMovie(newMovie);
        assertTrue(userService.getUser().getFavorites().contains(newMovie) && alreadyInFavMsg.equalsIgnoreCase("Movie is already in the favorites"));
    }

   
    @Test
    public void testRemoveFavoriteMovie() {
        User user = new User("user@example.com");
        userService.setUser(user);
        Movie newMovie1 = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000);
        Movie newMovie2 = new Movie("The Matrix", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), "Action", LocalDate.of(1999, 3, 31), 63000000);

        userService.addFavoriteMovie(newMovie1);
        userService.addFavoriteMovie(newMovie2);

        assertTrue(userService.getUser().isMovieInFavorites("Inception"));

        String successfullyRemovedMsg = userService.removeFavoriteMovie("Inception");
        assertFalse(userService.getUser().isMovieInFavorites("Inception"));
        assertTrue(successfullyRemovedMsg.equalsIgnoreCase("Movie removed from favorites"));

        String notInFavMsg = userService.removeFavoriteMovie("newMovie1");
        assertFalse(userService.getUser().isMovieInFavorites("Inception"));
        assertTrue(notInFavMsg.equalsIgnoreCase("Movie is not in the favorites"));
    }

    @Test
    public void testGetFavoriteMovies() {
        User user = new User("user@example.com");
        userService.setUser(user);
        Movie newMovie1 = new Movie("The Matrix", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), "Action", LocalDate.of(1999, 3, 31), 63000000);
        Movie newMovie2 = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000);

        userService.addFavoriteMovie(newMovie1);
        userService.addFavoriteMovie(newMovie2);

        String userDetails = userService.getUserDetails();

        String expectedUserDetails = "email: " + "user@example.com" + "\n" +
                                "FavoriteMovies: " + "[Inception, The Matrix]" ;
        assertEquals(expectedUserDetails, userDetails);
                            

        
    }

    @Test
    public void testSearchMoviesAmongFavourite() {
        User user = new User("user@example.com");
        userService.setUser(user);
        Movie newMovie1 = new Movie("The Matrix", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), "Action", LocalDate.of(1999, 3, 31), 63000000);
        Movie newMovie2 = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000);

        userService.addFavoriteMovie(newMovie1);
        userService.addFavoriteMovie(newMovie2);

        String searchedMovieDetails1 = userService.SearchMovieByTitleAmongFavorites("Inception");
        String expectedDetails1 = "Title: " + "Inception" + "\n" +
        "Cast: " + "[Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page]" + "\n" +
        "Category: " + "Sci-Fi"  + "\n" +
        "Release Date: " + "16/07/2010" + "\n" +
        "Budget: $" + "160000000";

        String searchedMovieDetails2 = userService.SearchMovieByTitleAmongFavorites("ABCD");
        String expectedDetails2 = "Movie is not found in the favorites";

        assertEquals(expectedDetails1, searchedMovieDetails1);
        assertEquals(expectedDetails2, searchedMovieDetails2);

    
    }
}
