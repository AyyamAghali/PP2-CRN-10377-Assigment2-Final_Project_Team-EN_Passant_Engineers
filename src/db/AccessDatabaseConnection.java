package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class AccessDatabaseConnection {
    public static void main(String[] args) {
        // JDBC URL for Access
        String url = "jdbc:ucanaccess://D://WORK//PP2-CRN-10377-Assigment2-Final_Project_Team-EN_Passant_Engineers//src//db//movie.accdb";
 
        // JDBC connection variables
        Connection connection = null;
 
        try {
            // Establish the connection
            connection = DriverManager.getConnection(url);
 
            // Perform database operations here
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the connection in the finally block
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}