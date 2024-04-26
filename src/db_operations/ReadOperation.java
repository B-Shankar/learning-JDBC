package db_operations;
import java.sql.*;

public class ReadOperation {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "000000";
        String query = "select * from employees;";
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

            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println();
                System.out.println("================================");
                System.out.println("Id: " + id );
                System.out.println("Name: " + name);
                System.out.println("Job Title: " + job_title);
                System.out.println("Salary: " + salary);
            }

            rs.close();
            stmt.close();
            con.close();

            System.out.println();
            System.out.println("Connection Closed Successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
mysql> select * from employees;
        +----+-------+--------------------+--------+
        | id | name  | job_title          | salary |
        +----+-------+--------------------+--------+
        |  1 | Kunal | Software Developer |  75000 |
        |  2 | Rahul | Devops Engineer    |  65000 |
        +----+-------+--------------------+--------+
        2 rows in set (0.00 sec)
 */