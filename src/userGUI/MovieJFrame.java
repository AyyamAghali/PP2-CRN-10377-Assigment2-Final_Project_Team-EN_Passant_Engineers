package gui;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import movie.movie;

import java.net.URL;
import java.net.MalformedURLException;

public class MovieJFrame {
	movie m = new movie("The mask of Zorro", "Martin Campbell", 90, 1998);
	JFrame img = new JFrame();
	JPanel pan = new JPanel();
	JLabel textLabel = new JLabel();
	JLabel imageLabel = new JLabel();

    public static void main(String[] args) throws IOException {
		MovieJFrame frame = new MovieJFrame();
	}
    
	MovieJFrame() throws MalformedURLException{
		img.setTitle(m.getTitle());
        img.setSize(1100, 1900);
		
		// pan.setLayout(null);
		
		textLabel.setText(m.getTitle());
        textLabel.setForeground(Color.BLACK);
        Font f = new Font("", Font.BOLD, 30);
        textLabel.setFont(f);
        textLabel.setBounds(5, 5, 300, 30);
		pan.add(textLabel);
		
        String path = "https://m.media-amazon.com/images/M/MV5BMzg4ZjQ4OGUtZjkxMi00Y2I2LWEzNTAtODI2ZjkxMGVjNTQwXkEyXkFqcGdeQXVyNjgxNTAwNjQ@._V1_.jpg";
        // String filename = "zorro.jpg";
        //BufferedImage bfr = ImageIO.read(url);
		URL url = new URL(path);
		ImageIcon image = new ImageIcon(url); 
		imageLabel.setIcon(image);
		imageLabel.setBounds(5, 4, 1004, 1600);
		pan.add(imageLabel);

		img.setContentPane(pan);
		img.setVisible(true);
	}
}