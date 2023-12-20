package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        userInputs obj = new userInputs();
        

        //insertUser(movieName: "Salam", movieDirector: "Ayxan", 90, 1992);
    }

    public static void insertUser(String movieName, String movieDirector, int runningTime, int releaseYear)
            throws ClassNotFoundException, SQLException {
        String url = "jdbc:ucanaccess://D://WORK//PP2-CRN-10377-Assigment2-Final_Project_Team-EN_Passant_Engineers//src//db//movie.accdb";
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection connection = DriverManager.getConnection(url);

        try {
            connection = DriverManager.getConnection(url);

            String insertQuery = "INSERT INTO userInputs (movieName,  movieDirector,  runningTime, releaseYear) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, movieName);
            preparedStatement.setString(2, movieDirector);
            preparedStatement.setInt(3, runningTime);
            preparedStatement.setInt(4, releaseYear);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("OK!");
            } else {
                System.out.println("NOT OK.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
