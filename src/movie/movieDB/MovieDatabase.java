package movie.movieDB;

import java.util.ArrayList;
import movie.movie;

public class MovieDatabase {
    private ArrayList<movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }

    // Helper method to find a movie by title
    private movie findMovie(String title) {
        for (movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(movie movie) {
        if (findMovie(movie.getTitle()) == null) {
            movies.add(movie);
            System.out.println("Movie added successfully.");
        } else {
            System.out.println("Movie already exists in the database.");
        }
    }

    public void removeMovie(String title) {
        movie movie = findMovie(title);
        if (movie != null) {
            movies.remove(movie);
            System.out.println("Movie removed successfully.");
        } else {
            System.out.println("Movie not found in the database.");
        }
    }

    public movie getMovieDetails(String title) {
        return findMovie(title);
    }

    
    public ArrayList<movie> getAllMovies() {
        return new ArrayList<>(movies); // Return a copy of the list to avoid external modifications
    }
}
