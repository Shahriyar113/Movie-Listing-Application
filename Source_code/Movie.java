import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

interface MovieService {
    List<Movie> searchMoviesByTitle(String title);
    List<Movie> searchMoviesByCast(String castMember);
    List<Movie> searchMoviesByCategory(String category);
}

public class Movie implements Comparable<Movie> {
    private String title;
    private List<String> cast;
    private String category;
    private LocalDate release_date;
    private int budget;

    public Movie(String title, List<String> cast, String category, LocalDate release_date, int budget) {
        this.title = title;
        this.cast = new ArrayList<>(cast);
        this.category = category;
        this.release_date = release_date;
        this.budget = budget;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getCast() {
        return new ArrayList<>(cast);
    }
    public void setCast(List<String> cast) {
        this.cast = new ArrayList<>(cast);
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public int getBudget() {
        return budget;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getDetails() {
       
        return "Title: " + title + "\n" +
               "Cast: " + cast.toString() + "\n" +
               "Category: " + category + "\n" +
               "Release Date: " + release_date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
               "Budget: $" + budget;
    }

    @Override
    public int compareTo(Movie other) {
        return this.title.compareTo(other.title);
    }
}