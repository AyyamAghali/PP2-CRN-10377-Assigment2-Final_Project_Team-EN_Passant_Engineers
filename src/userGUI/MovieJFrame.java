package userGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import movie.movie;

import javax.swing.JButton;

// import javafx.event.ActionEvent;

public class MovieJFrame {
    JFrame frame = new JFrame();
    JPanel pan = new JPanel();
    JLabel textLabel = new JLabel();
    JLabel imageLabel = new JLabel();
    JTextField movieName = new JTextField();
    JTextField movieDirector = new JTextField();
    JButton addButton = new JButton();
    String path = "https://m.media-amazon.com/images/M/MV5BMzg4ZjQ4OGUtZjkxMi00Y2I2LWEzNTAtODI2ZjkxMGVjNTQwXkEyXkFqcGdeQXVyNjgxNTAwNjQ@._V1_.jpg";
    movie movie = new movie("The mask of zorro", "Martin Campbell", 90, 1998, path);

    /*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost";

    static final String USER = "root";
    static final String PASS = "";/* */
    public static void main(String[] args) throws MalformedURLException, Exception {
        MovieJFrame mJframe = new MovieJFrame();

        /* Connection cnct = null;
        Statement st = null;

        Class.forName("JDBC_DRIVER");
        
        cnct = DriverManager.getConnection(DB_URL, USER, PASS);
        st = cnct.createStatement();

        String sql = "BUILD DATABASE";
        st.executeUpdate(sql);
        System.out.println("The database is being built");
        st.close();
        cnct.close();/* */
    }

    MovieJFrame() {
        frame.setSize(500, 500);

       // pan.setLayout(new GridLayout(3, 2, 5, 5));

        textLabel.setForeground(Color.BLACK);
        Font f = new Font("", Font.BOLD, 30);
        textLabel.setFont(f);
        textLabel.setBounds(5, 5, 300, 30);
        pan.add(textLabel);

        // Set preferred size for the text fields
        movieName.setColumns(15);
        movieDirector.setColumns(15);

        pan.add(new JLabel("Movie Name:"));
        pan.add(movieName);
        pan.add(new JLabel("Movie Director:"));
        pan.add(movieDirector);

       addButton.setText("insert");
       addButton.setBounds(100, 100, 100, 100);
       pan.add(addButton);
       addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (movieName.getText().equals(movie.getTitle()) || movieDirector.getText().equals(movie.getDirector()) && movieName.getText().equals(movie.getTitle())){ 
                    ImageIcon img;
                    try {
                        img = new ImageIcon(movie.getURL());
                        frame.setSize(img.getIconWidth(), img.getIconHeight());
                        imageLabel.setIcon(img);
                    } catch (MalformedURLException e1) {
                         e1.printStackTrace();
                    }
                }
            }
        });
        pan.add(imageLabel);

        frame.setContentPane(pan);
        frame.setVisible(true);
    }
}