package userGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class WatchlistPanel extends JPanel {
    private JList<String> watchlist;
    private DefaultListModel<String> watchlistModel;
    private JButton removeFromWatchlistButton;
    private List<String> allMovies; 

    public WatchlistPanel(List<String> allMovies) {
        this.allMovies = allMovies;
        setLayout(new BorderLayout());

        watchlistModel = new DefaultListModel<>();
        watchlist = new JList<>(watchlistModel);
        watchlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        removeFromWatchlistButton = new JButton("Remove from Watchlist");
        removeFromWatchlistButton.addActionListener(e -> removeFromWatchlist());

        add(new JScrollPane(watchlist), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeFromWatchlistButton);
        add(buttonPanel, BorderLayout.SOUTH);

        updateWatchlist();
    }

    private void removeFromWatchlist() {
        String selectedMovie = watchlist.getSelectedValue();
        if (selectedMovie != null) {
            watchlistModel.removeElement(selectedMovie);
        }
    }

    public void updateWatchlist() {
        watchlistModel.clear();
        List<String> sortedWatchlist = allMovies.stream()
                                               .sorted() // Sorting alphabetically
                                               .collect(Collectors.toList());
        sortedWatchlist.forEach(watchlistModel::addElement);
    }

}
