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
    public void test_user_registration_1() {

        User newUser = new User("user123@example.com");
        userService.setUser(newUser);
        assertTrue(userService.is_registration_successful());
    }

    @Test
    public void test_user_registration_2() {
        User newUser = new User("@example.com");
        userService.setUser(newUser);
        assertFalse(userService.is_registration_successful());
    }

    @Test
    public void test_user_registration_3() {
        User newUser = new User(null);
        userService.setUser(newUser);
        assertFalse(userService.is_registration_successful());
    }
    @Test
    public void test_user_registration_4() {
        User newUser = new User("abcd");
        userService.setUser(newUser);
        assertFalse(userService.is_registration_successful());
    }

    @Test
    public void testAddFavoriteMovie() {
        User user = new User("user@example.com");
        userService.setUser(user);
        Movie newMovie = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000);
        String succesfully_added_msg = userService.addFavoriteMovie(newMovie);
        assertTrue(userService.getUser().getFavorites().contains(newMovie) && succesfully_added_msg.equalsIgnoreCase("Movie added to favorites"));
        String already_in_fav_msg = userService.addFavoriteMovie(newMovie);
        assertTrue(userService.getUser().getFavorites().contains(newMovie) && already_in_fav_msg.equalsIgnoreCase("Movie is already in the favorites"));
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

        String successfully_removed_msg = userService.removeFavoriteMovie("Inception");
        assertFalse(userService.getUser().isMovieInFavorites("Inception"));
        assertTrue(successfully_removed_msg.equalsIgnoreCase("Movie removed from favorites"));

        String not_in_fav_msg = userService.removeFavoriteMovie("newMovie1");
        assertFalse(userService.getUser().isMovieInFavorites("Inception"));
        assertTrue(not_in_fav_msg.equalsIgnoreCase("Movie is not in the favorites"));
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
        String expected_details1 = "Title: " + "Inception" + "\n" +
        "Cast: " + "[Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page]" + "\n" +
        "Category: " + "Sci-Fi"  + "\n" +
        "Release Date: " + "16/07/2010" + "\n" +
        "Budget: $" + "160000000";

        String searchedMovieDetails2 = userService.SearchMovieByTitleAmongFavorites("ABCD");
        String expected_details2 = "Movie is not found in the favorites";

        assertEquals(expected_details1, searchedMovieDetails1);
        assertEquals(expected_details2, searchedMovieDetails2);

    
    }
}
