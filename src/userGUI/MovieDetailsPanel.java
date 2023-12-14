package userGUI;
import javax.swing.*;
import java.awt.*;

public class MovieDetailsPanel extends JPanel {
    private JLabel titleLabel, directorLabel, yearLabel, runningTimeLabel;

    public MovieDetailsPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        titleLabel = new JLabel("Title: ");
        directorLabel = new JLabel("Director: ");
        yearLabel = new JLabel("Year: ");
        runningTimeLabel = new JLabel("Running Time: ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(directorLabel, gbc);

        gbc.gridy = 2;
        add(yearLabel, gbc);

        gbc.gridy = 3;
        add(runningTimeLabel, gbc);
    }

    public void setMovieDetails(String title, String director, int year, int runningTime) {
        titleLabel.setText("Title: " + title);
        directorLabel.setText("Director: " + director);
        yearLabel.setText("Year: " + year);
        runningTimeLabel.setText("Running Time: " + runningTime + " mins");
    }
}
