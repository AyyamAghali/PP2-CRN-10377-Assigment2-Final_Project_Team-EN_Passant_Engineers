package userGUI;
import javax.swing.*;

import movie.movie;

public class MovieApp extends JFrame {

    public MovieApp() {
        setTitle("Online Movie Database Management System");
        setSize(800, 600); // Set the initial size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initialize and add components here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MovieApp().setVisible(true);
        });
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Movie Browsing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        MovieBrowsingPanel panel = new MovieBrowsingPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
