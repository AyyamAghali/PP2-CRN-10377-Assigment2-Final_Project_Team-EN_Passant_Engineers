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
        // Implement the logic to view details of the selected movie
        String selectedMovie = movieList.getSelectedValue();
        System.out.println("Viewing details of: " + selectedMovie);
    }

    private void addToWatchlist() {
        // Implement the logic to add the selected movie to the watchlist
        String selectedMovie = movieList.getSelectedValue();
        System.out.println("Adding to watchlist: " + selectedMovie);
    }
}
