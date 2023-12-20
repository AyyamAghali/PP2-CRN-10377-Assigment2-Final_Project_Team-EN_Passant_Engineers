package userGUI;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WatchlistPanel extends JPanel {
    private JList<String> watchlist;
    private DefaultListModel<String> watchlistModel;
    private JButton removeFromWatchlistButton;

    public WatchlistPanel() {
        setLayout(new BorderLayout());

        watchlistModel = new DefaultListModel<>();
        watchlist = new JList<>(watchlistModel);
        watchlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        removeFromWatchlistButton = new JButton("Remove from Watchlist");
        removeFromWatchlistButton.addActionListener(e -> removeFromWatchlist());

        // Adding components to the panel
        add(new JScrollPane(watchlist), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeFromWatchlistButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateWatchlist(List<String> movies) {
        watchlistModel.clear();
        movies.forEach(watchlistModel::addElement);
    }

    private void removeFromWatchlist() {
        String selectedMovie = watchlist.getSelectedValue();
        if (selectedMovie != null) {
            watchlistModel.removeElement(selectedMovie);
            System.out.println("Removed from watchlist: " + selectedMovie);
        }
    }
}
