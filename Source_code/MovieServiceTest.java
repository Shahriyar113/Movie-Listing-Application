package Source_code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieServiceTest {
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        System.out.println("Hello");
        this.movieService = new MovieService();
        Movie movie1 = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16),160000000);
        Movie movie2 = new Movie("The Matrix", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), "Action", LocalDate.of(1999, 3, 31), 63000000);
        Movie movie3 = new Movie("Gladiator", Arrays.asList("Russell Crowe", "Joaquin Phoenix", "Connie Nielsen"), "Historical Drama", LocalDate.of(2000, 5, 5), 103000000);
        Movie movie4 = new Movie("The Grand Budapest Hotel", Arrays.asList("Ralph Fiennes", "F. Murray Abraham", "Mathieu Amalric"), "Comedy", LocalDate.of(2014, 3, 28), 25000000);
        Movie movie5 = new Movie("Interstellar", Arrays.asList("Matthew McConaughey", "Carrie-Anne Moss", "Jessica Chastain"), "Sci-Fi", LocalDate.of(2014, 11, 7), 63000000);
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);
        movieService.addMovie(movie4);
        movieService.addMovie(movie5);
    }


    @Test
    public void testSearchMoviesByTitle_1() {
       
        Movie searchedMovie = movieService.searchMoviesByTitle("The Matrix");
        String searchedMovieTitle = searchedMovie.getTitle();
        assertEquals("The Matrix", searchedMovieTitle);
    }

    @Test
    public void testSearchMoviesByTitle_2() {
        
        Movie searchedMovie = movieService.searchMoviesByTitle("The Matrix 2");
        String searchedMovieTitle = searchedMovie.getTitle();
        assertEquals("Movie not found", searchedMovieTitle);
    }

    @Test
    public void testSearchMoviesByCast_1() {
        
        List<Movie> searchedMovies = movieService.searchMoviesByCast("Carrie-Anne Moss");

        List<String> searchedMovieTitles = new ArrayList<>();
        for (Movie movie : searchedMovies) {
            searchedMovieTitles.add(movie.getTitle());
        } 

        List<String> expectedMovieTitles = Arrays.asList("Interstellar","The Matrix");
        assertEquals(expectedMovieTitles,searchedMovieTitles);
    }

    @Test
    public void testSearchMoviesByCast_2() {
        
        List<Movie> searchedMovies = movieService.searchMoviesByCast("ABCD");
        assertTrue(searchedMovies.isEmpty());
    }

    public void testSearchMoviesByCast_3() {
        
        List<Movie> searchedMovies = movieService.searchMoviesByCast(null);
        assertTrue(searchedMovies.isEmpty());
    }

    @Test
    public void testSearchMoviesByCategory_1() {
    
        List<Movie> searchedMovies = movieService.searchMoviesByCategory("Sci-Fi");

        List<String> searchedMovieTitles = new ArrayList<>();
        for (Movie movie : searchedMovies) {
            searchedMovieTitles.add(movie.getTitle());
        } 

        List<String> expectedMovieTitles = Arrays.asList("Inception","Interstellar");
        assertEquals(expectedMovieTitles,searchedMovieTitles);
    }

    @Test
    public void testSearchMoviesByCategory_2() {
    
        List<Movie> searchedMovies = movieService.searchMoviesByCategory("ABCD");
        assertTrue(searchedMovies.isEmpty());

    }

    @Test
    public void testSearchMoviesByCategory_3() {
    
        List<Movie> searchedMovies = movieService.searchMoviesByCategory(null);
        assertTrue(searchedMovies.isEmpty());

    }

    @Test
    public void testGetMovieDetails_1() {
        Movie searched_movie = movieService.searchMoviesByTitle("Inception");
        String searchedMovieDetails = movieService.getMovieDetails(searched_movie);
        String expected_details = "Title: " + "Inception" + "\n" +
               "Cast: " + "[Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page]" + "\n" +
               "Category: " + "Sci-Fi"  + "\n" +
               "Release Date: " + "16/07/2010" + "\n" +
               "Budget: $" + "160000000";
        assertEquals(expected_details, searchedMovieDetails);
    }

    @Test
    public void testGetMovieDetails_2(){
        Movie searched_movie = movieService.searchMoviesByTitle("ABCD");
        String searchedMovieDetails = movieService.getMovieDetails(searched_movie);
        assertEquals("N/A", searchedMovieDetails);
    }




}
