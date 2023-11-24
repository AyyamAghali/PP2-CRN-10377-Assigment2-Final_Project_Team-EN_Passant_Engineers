
import java.util.ArrayList;

public class MovieDatabase {
    private ArrayList<movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }
    // Helper method to find a movie by title
    private movie findMovie(String title) {
        // Check for duplicates before adding
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
        } else {
            System.out.println("Movie already exists in the database.");
        }
        
    }

    public void removeMovie(String title) {
        // Remove the movie by title
    }

    public movie getMovieDetails(String title) {
    return null;
}
}      
