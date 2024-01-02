package movie.movieDB;

import movie.Movie;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Manages a collection of movies with functionalities to add, remove, retrieve, and sort movies.
 */
public class MovieDatabase implements Serializable {
    private Map<String, Movie> movies;

    public MovieDatabase() {
        this.movies = new HashMap<>();
        loadMovies();
    }

    public void addMovie(Movie movie) {
        if (movie == null || movies.containsKey(movie.getTitle())) {
            return; // Avoid adding null or duplicate movies
        }
        movies.put(movie.getTitle(), movie);
        saveMovies();
    }

    public void removeMovie(String title) {
        if (movies.remove(title) != null) {
            saveMovies();
        }
    }

    public Movie getMovieDetails(String title) {
        return movies.get(title);
    }

    public List<Movie> filterMovies(Predicate<Movie> predicate) {
        return movies.values().stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Movie> getSortedMovies(Comparator<Movie> comparator) {
        return movies.values().stream().sorted(comparator).collect(Collectors.toList());
    }

    public Collection<Movie> getAllMovies() {
        return new ArrayList<>(movies.values());
    }

    private void saveMovies() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("movies.dat"))) {
            out.writeObject(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadMovies() {
        File file = new File("movies.dat");
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            movies = (Map<String, Movie>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
