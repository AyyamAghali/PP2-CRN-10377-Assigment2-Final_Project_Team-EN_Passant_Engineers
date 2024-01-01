package userGUI;

import javax.swing.*;
import java.awt.*;

public class MovieApp extends JFrame {

    public MovieApp() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Movie Database Application");
        setSize(800, 600); // Set initial size
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel loginPanel = createLoginPanel();
        JPanel movieBrowsingPanel = createMovieBrowsingPanel();


        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Browse Movies", movieBrowsingPanel);
 

        add(tabbedPane);
    }

    private JPanel createLoginPanel() {
        // Initialize and return the LoginPanel
        return new LoginPanel();
    }

    private JPanel createMovieBrowsingPanel() {
        // Initialize and return the MovieBrowsingPanel
        return new MovieBrowsingPanel();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MovieApp().setVisible(true);
            }
        });
    }
}
