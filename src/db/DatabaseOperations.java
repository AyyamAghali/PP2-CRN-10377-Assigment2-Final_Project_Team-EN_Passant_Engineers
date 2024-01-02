package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import movie.movie;

public class DatabaseOperations {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        // userInputs obj = new userInputs();
        movie movie = new movie("The mask of zorro", "Martin Campbell", 90, 1998, "");
        ArrayList<movie> list = new ArrayList<movie>();
        list.add(movie);
        insertUser(list); 
    }

    public static void connection(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void insertUser(ArrayList<movie> list)
            throws ClassNotFoundException, SQLException {
        connection();
        String url = "jdbc:ucanaccess://D://WORK//PP2-CRN-10377-Assigment2-Final_Project_Team-EN_Passant_Engineers//src//db//movie.accdb";
        Connection connection = DriverManager.getConnection(url);

        try {
            connection = DriverManager.getConnection(url);

            String insertQuery = "INSERT INTO userInputs (movieName,  movieDirector,  runningTime, releaseYear) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
           
            for (movie movie : list){
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDirector());
            preparedStatement.setInt(3, movie.getRunningTime());
            preparedStatement.setInt(4, movie.getYear());
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("OK!");
            } else {
                System.out.println("NOT OK.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
}
