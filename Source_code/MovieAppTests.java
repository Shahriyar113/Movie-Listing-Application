import static org.junit.Assert.*;
import org.junit.Test;

public class MovieAppTests {
    @Test
    public void testAddFavorite() {
        User user = new User("user@example.com");
        Movie movie = new Movie("Inception", Arrays.asList("Leonardo DiCaprio"), "Sci-Fi", LocalDate.of(2010, 7, 16), new BigDecimal("160000000"));
        user.addFavorite(movie);
        assertTrue(user.getFavorites().contains(movie));
    }

    @Test
    public void testRemoveFavorite() {
        User user = new User("user@example.com");
        Movie movie = new Movie("Inception", Arrays.asList("Leonardo DiCaprio"), "Sci-Fi", LocalDate.of(2010, 7, 16), new BigDecimal("160000000"));
        user.addFavorite(movie);
        user.removeFavorite(movie);
        assertFalse(user.getFavorites().contains(movie));
    }
}
