package Source_code;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Load_data {

    List<Movie> movies;

    public void load_movies() {

        Movie movie1 = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Sci-Fi", LocalDate.of(2010, 7, 16),160000000);
        Movie movie2 = new Movie("The Matrix", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), "Action", LocalDate.of(1999, 3, 31), 63000000);
        Movie movie3 = new Movie("Gladiator", Arrays.asList("Russell Crowe", "Joaquin Phoenix", "Connie Nielsen"), "Historical Drama", LocalDate.of(2000, 5, 5), 103000000);
        Movie movie4 = new Movie("The Grand Budapest Hotel", Arrays.asList("Ralph Fiennes", "F. Murray Abraham", "Mathieu Amalric"), "Comedy", LocalDate.of(2014, 3, 28), 25000000);
        Movie movie5 = new Movie("Interstellar", Arrays.asList("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain"), "Sci-Fi", LocalDate.of(2014, 11, 7), 63000000);
        Movie movie6 = new Movie("Gone Girl", Arrays.asList("Ben Affleck", "Rosamund Pike", "Neil Patrick Harris"), "Thriller", LocalDate.of(2014, 10, 3), 61000000);
        Movie movie7 = new Movie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", LocalDate.of(2008, 7, 18), 185000000);
        Movie movie8 = new Movie("The Social Network", Arrays.asList("Jesse Eisenberg", "Andrew Garfield", "Justin Timberlake"), "Drama", LocalDate.of(2010, 10, 1), 40000000);
        Movie movie9 = new Movie("Avatar", Arrays.asList("Sam Worthington", "Zoe Saldana", "Sigourney Weaver"), "Sci-Fi", LocalDate.of(2009, 12, 18), 237000000);
        Movie movie10 = new Movie("Mad Max: Fury Road", Arrays.asList("Tom Hardy", "Charlize Theron", "Nicholas Hoult"), "Action", LocalDate.of(2015, 5, 15), 150000000);
                
    }
    
}
