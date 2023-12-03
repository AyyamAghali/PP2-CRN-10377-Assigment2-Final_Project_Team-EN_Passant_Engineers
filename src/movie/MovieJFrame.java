package movie;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.URL;

public class MovieJFrame {
    public static void main(String[]args) throws IOException {
		movie m = new movie("The mask of Zorro", "Martin Campbell", 90, 1998);
		JFrame img = new JFrame();
		img.setTitle(m.getTitle());
        img.setSize(1100, 1700);
		
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		JLabel textLabel = new JLabel();
		textLabel.setText(m.getTitle());
        textLabel.setForeground(Color.BLACK);
        Font f = new Font("", Font.BOLD, 30);
        textLabel.setFont(f);
        
        textLabel.setBounds(5, 5, 300, 30);
		pan.add(textLabel);
		
        String path = "https://m.media-amazon.com/images/M/MV5BMzg4ZjQ4OGUtZjkxMi00Y2I2LWEzNTAtODI2ZjkxMGVjNTQwXkEyXkFqcGdeQXVyNjgxNTAwNjQ@._V1_.jpg";
        String filename = "zorro.jpg";
        URL url = new URL(path);
        //BufferedImage bfr = ImageIO.read(url);
		ImageIcon image = new ImageIcon(url); 
		
        JLabel imageLabel = new JLabel();
		imageLabel.setIcon(image);
		imageLabel.setBounds(5, 4, 1009, 1600);
		pan.add(imageLabel);

		img.setContentPane(pan);
		img.setVisible(true);
	}
}