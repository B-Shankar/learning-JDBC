package db_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "000000";
        String query = "DELETE FROM employees WHERE id = 4;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully!");

            Statement stmt = con.createStatement();

            int rowsAffected = stmt.executeUpdate(query);
            // for inserting/deleting/updating data -> executeUpdate()  //1 rows are affected
            // for retrieving data -> executeQuery()  //2 rows in set

            if(rowsAffected > 0){
                System.out.println("DELETION Successful." + rowsAffected + "row(s) affected.");
            } else {
                System.out.println("DELETION Failed!");
            }

            stmt.close();
            con.close();

            System.out.println();
            System.out.println("Connection Closed Successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
