package userGUI;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieBrowsingPanel extends JPanel {
    private JList<String> movieList; // Displaying movie titles as Strings
    private DefaultListModel<String> movieListModel;
    private JButton viewDetailsButton, addToWatchlistButton;

    public MovieBrowsingPanel() {
        setLayout(new BorderLayout());
        
        movieListModel = new DefaultListModel<>();
        movieList = new JList<>(movieListModel);
        movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Buttons for additional movie actions
        viewDetailsButton = new JButton("View Details");
        addToWatchlistButton = new JButton("Add to Watchlist");

        // Event listeners for buttons (implement the logic as needed)
        viewDetailsButton.addActionListener(e -> viewMovieDetails());
        addToWatchlistButton.addActionListener(e -> addToWatchlist());

        // Adding components to the panel
        add(new JScrollPane(movieList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(addToWatchlistButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateMovieList(List<String> movies) {
        movieListModel.clear();
        for (String movie : movies) {
            movieListModel.addElement(movie);
        }
    }

    private void viewMovieDetails() {

        String selectedMovie = movieList.getSelectedValue();
        System.out.println("Viewing details of: " + selectedMovie);
    }

    private void addToWatchlist() {
        String selectedMovie = movieList.getSelectedValue();
        System.out.println("Adding to watchlist: " + selectedMovie);
    }
}
private void initializeUI() {
        setLayout(new BorderLayout());

        movieListModel = new DefaultListModel<>();
        movieList = new JList<>(movieListModel);
        movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(movieList);

        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewDetails();
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(viewDetailsButton, BorderLayout.SOUTH);
    }

   private void loadMovies() {
        String query = "SELECT title, director, releaseYear, runningTime FROM movies";

        try (Connection conn = AccessDatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String title = rs.getString("title");
                String director = rs.getString("director");
                int releaseYear = rs.getInt("releaseYear");
                int runningTime = rs.getInt("runningTime");

                Movie movie = new Movie(title, director, releaseYear, runningTime);
                movieListModel.addElement(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    private void handleViewDetails() {
        Movie selectedMovie = movieList.getSelectedValue();
        if (selectedMovie != null) {
            // Handle viewing movie details
            JOptionPane.showMessageDialog(this, "Details for: " + selectedMovie.getTitle());
        } else {
            JOptionPane.showMessageDialog(this, "No movie selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
