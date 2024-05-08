package Source_code;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//This class encapsulates the information of a movie
public class Movie implements Comparable<Movie> {
    private String title;
    private List<String> cast;
    private String category;
    private LocalDate releaseDate;
    private int budget;

    public Movie(String title, List<String> cast, String category, LocalDate releaseDate, int budget) {
        this.title = title;
        this.cast = new ArrayList<>(cast);
        this.category = category;
        this.releaseDate = releaseDate;
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDetails() {
       
        return "Title: " + title + "\n" +
               "Cast: " + cast.toString() + "\n" +
               "Category: " + category + "\n" +
               "Release Date: " + releaseDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
               "Budget: $" + budget;
    }

    //This method is used to sort the movies by their titles
    @Override
    public int compareTo(Movie other) {
        return this.title.compareTo(other.title);
    }
}