package userGUI;
import javax.swing.*;

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
}
