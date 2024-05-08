package Source_code;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;


//Assumung that at a time only one user can use the system
public class Main {

    private UserService userService;
    private MovieService movieService;

    public Main() {
        this.userService = new UserService();
        this.movieService = new MovieService();
    }

    public void LoadMoviesData()
    {
        Movie movie1 = new Movie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Heath Ledger"), "Sci-Fi", LocalDate.of(2010, 7, 16),160000000);
        Movie movie2 = new Movie("The Matrix", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), "Action", LocalDate.of(1999, 3, 31), 63000000);
        Movie movie3 = new Movie("Gladiator", Arrays.asList("Russell Crowe", "Joaquin Phoenix", "Connie Nielsen"), "Historical Drama", LocalDate.of(2000, 5, 5), 103000000);
        Movie movie4 = new Movie("The Grand Budapest Hotel", Arrays.asList("Ralph Fiennes", "F. Murray Abraham", "Mathieu Amalric"), "Comedy", LocalDate.of(2014, 3, 28), 25000000);
        Movie movie5 = new Movie("Interstellar", Arrays.asList("Matthew McConaughey", "Heath Ledger", "Jessica Chastain"), "Sci-Fi", LocalDate.of(2014, 11, 7), 63000000);
        Movie movie6 = new Movie("Gone Girl", Arrays.asList("Ben Affleck", "Rosamund Pike", "Neil Patrick Harris"), "Thriller", LocalDate.of(2014, 10, 3), 61000000);
        Movie movie7 = new Movie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", LocalDate.of(2008, 7, 18), 185000000);
        Movie movie8 = new Movie("The Social Network", Arrays.asList("Jesse Eisenberg", "Andrew Garfield", "Justin Timberlake"), "Drama", LocalDate.of(2010, 10, 1), 40000000);
        Movie movie9 = new Movie("Avatar", Arrays.asList("Sam Worthington", "Zoe Saldana", "Sigourney Weaver"), "Sci-Fi", LocalDate.of(2009, 12, 18), 237000000);
        Movie movie10 = new Movie("Mad Max: Fury Road", Arrays.asList("Tom Hardy", "Charlize Theron", "Heath Ledger"), "Action", LocalDate.of(2015, 5, 15), 150000000);
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);
        movieService.addMovie(movie4);
        movieService.addMovie(movie5);
        movieService.addMovie(movie6);
        movieService.addMovie(movie7);
        movieService.addMovie(movie8);
        movieService.addMovie(movie9);
        movieService.addMovie(movie10);


    }

    public void ShowHomeMenu()
    {
        System.out.println("1. See All Movies");
        System.out.println("2. Search Movies by Title");
        System.out.println("3. Search Movies by Cast");
        System.out.println("4. Search Movies by Category");
        System.out.println("5. Add Movie to Favorites");
        System.out.println("6. Remove Movie from Favorites");
        System.out.println("7. Show Personal Details and Favorite Movies");
        System.out.println("8. Exit");
    }


    public static void main(String[] args) {
        Main main = new Main();

        //loading the movies data
        main.LoadMoviesData();

        //Now we will implement a console IO for this system
        //So,We will provide a menu to the user

        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.print("Provide your email address to register: ");
            String email = input.nextLine();
            //validating the email
            User user = new User(email);
            main.userService.setUser(user);
            if(main.userService.isRegistrationSuccessful())
            {
                System.out.println();
                System.out.println("---------Registration Successful---------------");
                System.out.println();
                System.out.println("--------------------WELCOME TO MOVIE WORLD---------------");

                System.out.println();

                while (true) {
                    System.out.println();
                    System.out.println("Home Menu");
                    System.out.println("--------------");
                    System.out.println();
                    System.out.println("1. See All Movies");
                    System.out.println("2. Search Movies by Title");
                    System.out.println("3. Search Movies by Cast");
                    System.out.println("4. Search Movies by Category");
                    System.out.println("5. Add Movie to Favorites");
                    System.out.println("6. Remove Movie from Favorites");
                    System.out.println("7. Show Favorite Movies");
                    System.out.println("8. Exit");
                    System.out.println();
                    System.out.print("Enter your choice from (1-8): ");

                    int choice = 0;

                    //handling inputMismatchException
                    //handling the case if user enters a string instead of an integer
                    try {
                         choice = input.nextInt();
                         input.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Invalid choice. Please try again");
                        input.nextLine();
                        continue;
                    }
                    System.out.println();

                    if (choice == 1) {
                        //See All Movies
                        System.out.println("All Movies: ");
                        System.out.println("------------ ");
                        int index = 1;
                        for (Movie movie : main.movieService.getAllMovies()) {
                            System.out.println(String.valueOf(index)+ "." + movie.getTitle());
                            index++;
                        }
                        while (true) {
                            System.out.println();
                            System.out.print("Enter the title of the movie you want to see details(or enter \"back\" to go back to the home menu): ");
                            String title = input.nextLine();
                            if (title.equalsIgnoreCase("back")) {
                                break;
                            }
                            System.out.println();
                            Movie searchedMovie = main.movieService.searchMoviesByTitle(title);
                            if (searchedMovie instanceof NullMovie) {
                                System.out.println("No movie found with this title");
                            } else {
                                System.out.println(searchedMovie.getDetails());
                            }
                        }
                        
                    } else if (choice == 2) {
                        //Search Movies by Title
                        while (true) {
                            System.out.print("Enter the title of the movie you want to search(or enter \"back\" to go back to the home menu): ");
                            String title = input.nextLine();
                            System.out.println();
                            if (title.equalsIgnoreCase("back")) {
                                break;
                            }
                            Movie searchedMovie = main.movieService.searchMoviesByTitle(title);
                            if (searchedMovie instanceof NullMovie) {
                                System.out.println("No movie found with this title");
                            } else {
                                System.out.println(searchedMovie.getDetails());
                                System.out.println();
                            } 
                        }
                        
                    } else if (choice == 3) {
                        //Search Movies by Cast

                        while (true) {

                            System.out.print("Enter the name of the cast member(or enter \"back\" to go back to the home menu): ");
                            String castMember = input.nextLine();
                            if (castMember.equalsIgnoreCase("back")) {
                                break;
                            }
                            System.out.println();
                            System.out.println("Movies with this cast: ");
                            System.out.println("----------------------");
                            System.out.println();
                            //if no movie is found with this cast, then print a message
                            if(main.movieService.searchMoviesByCast(castMember).isEmpty())
                            {
                                System.out.println("No movie found with this cast");
                                System.out.println();
                            }
                            for (Movie movie : main.movieService.searchMoviesByCast(castMember)) {
                                System.out.println(movie.getDetails());
                                System.out.println();
                        }
                            
                        }
                        
                    } else if (choice == 4) {
                        //Search Movies by Category
                        while (true) {
                            System.out.print("Enter the category of the movie you want to search(or enter \"back\" to go back to the home menu): ");
                            String category = input.nextLine();
                            if (category.equalsIgnoreCase("back")) {
                                break;
                            }
                            System.out.println();
                            System.out.println("Movies in this category: ");
                            System.out.println("------------------------");
                            System.out.println();
                            //if no movie is found with this category, then print a message
                            if(main.movieService.searchMoviesByCategory(category).isEmpty())
                            {
                                System.out.println("No movie found with this category");
                                System.out.println();
                            }
                            for (Movie movie : main.movieService.searchMoviesByCategory(category)) {
                                System.out.println(movie.getDetails());
                                System.out.println();
                            }
                        }
                      
                    } else if (choice == 5) {
                        //Add Movie to Favorites
                       while (true) {

                            System.out.println("The list of all movies: ");
                            System.out.println("------------------------");
                            int index = 1;
                            for (Movie movie : main.movieService.getAllMovies()) {
                                System.out.println(String.valueOf(index)+ "." + movie.getTitle());
                                index++;
                            }
                            System.out.println();

                            System.out.print("Now enter the title of the movie you want to add to favorites(or enter \"back\" to go back to the home menu): ");
                            String title = input.nextLine();
                            if (title.equalsIgnoreCase("back")) {
                                break;
                            }
                            Movie searchedMovie = main.movieService.searchMoviesByTitle(title);
                            if (searchedMovie instanceof NullMovie) {
                                System.out.println();
                                System.out.println("-----------No movie found with this title in our server--------------");
                                System.out.println();
                            } else {
                                //if movie is already in the favorites, then do not add it again
                                System.out.println();
                                System.out.println("-----------"+main.userService.addFavoriteMovie(searchedMovie)+"-----------");
                                System.out.println();
                               
                            }
                        
                       }
                    } else if (choice == 6) {

                        
                      while (true) {
                        System.out.println("Here is the list of your favorite movies: ");
                        System.out.println("-----------------------------------------");
                        Set<Movie> favoriteMovies = user.getFavorites();
                        int index = 1;
                        for (Movie movie : favoriteMovies) {
                            System.out.println(String.valueOf(index)+ "." + movie.getTitle());
                            index++;
                        }
                        System.out.println();
                        System.out.print("Now enter the title of the movie you want to remove from favorites(or enter \"back\" to go back to the home menu): ");
                        //Remove Movie from Favorites
                        String title = input.nextLine();
                        if (title.equalsIgnoreCase("back")) {
                            break;
                        }
                        
                        System.out.println();
                        System.out.println("-----------"+main.userService.removeFavoriteMovie(title)+"-----------");
                        System.out.println();
                    
                }
                        
                      }

                      else if(choice == 7)
                      {
                        //Show Favorite Movies
                        System.out.println("Peronal Details: ");
                        System.out.println("-----------------");
                        System.out.println();
                        System.out.println(main.userService.getUserDetails());
                        System.out.println();
                        System.out.println("Description of your favorite movies: ");
                        System.out.println("--------------------------------------");
                        Set<Movie> favoriteMovies = main.userService.getUser().getFavorites();
                        for (Movie movie : favoriteMovies) {
                            System.out.println(movie.getDetails());
                            System.out.println();
                        }

                        //search a movie among favorites
                        while(true)
                        {
                            System.out.print("Enter the title of the movie you want to search among favorites(or enter \"back\" to go back to the home menu): ");
                            String title = input.nextLine();
                            if(title.equalsIgnoreCase("back"))
                            {
                                break;
                            }
                            System.out.println();
                            System.out.println("Description of the movie: ");
                            System.out.println("---------------------------");
                            System.out.println();
                            System.out.println(main.userService.SearchMovieByTitleAmongFavorites(title));
                            System.out.println();

                        }
                      }
                      else if(choice == 8)
                      {
                          System.out.println("--------------Thank you for using our system. Goodbye!----------------------");
                          System.out.println();
                          System.exit(0);
                      }
                      else
                      {
                          System.out.println("Invalid choice. Please try again");
                      }
                
            }
           
        }

        else
        {
            System.out.println("Invalid email address. Please try again");
            System.out.println();
        }



    }


    
}

}