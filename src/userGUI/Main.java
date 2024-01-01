package userGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Set the look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Initialize the main application window (assuming MovieApp is your main JFrame)
        MovieApp mainApp = new MovieApp();
        mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainApp.pack(); // Adjusts window to fit components
        mainApp.setLocationRelativeTo(null); // Centers window
        mainApp.setVisible(true);
    }
}
