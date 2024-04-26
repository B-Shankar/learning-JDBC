package db_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperation {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "000000";
        String query = "UPDATE employees " +
                "SET job_title = 'Full stack Developer', salary = 70000.0 " +
                "WHERE id = 2;";
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
                System.out.println("UPDATED Successful." + rowsAffected + "row(s) affected.");
            } else {
                System.out.println("UPDATED Failed!");
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
