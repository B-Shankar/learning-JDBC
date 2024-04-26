package db_operations;

import java.sql.*;

public class InsertOperation {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "000000";
        String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(4, 'Vishal', 'React Developer', 77000.0);";
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
            // for inserting data -> executeUpdate()  //1 rows are affected
            // for retrieving data -> executeQuery()  //2 rows in set

            if(rowsAffected > 0){
                System.out.println("INSERT Successful." + rowsAffected + "row(s) affected.");
            } else {
                System.out.println("Insertion Failed!");
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

/*
mysql> select * from employees;
+----+---------+----------------------+--------+
| id | name    | job_title            | salary |
+----+---------+----------------------+--------+
|  1 | Kunal   | Software Developer   |  75000 |
|  2 | Rahul   | Devops Engineer      |  65000 |
|  3 | Harshit | Full stack Developer |  87000 |
+----+---------+----------------------+--------+
3 rows in set (0.00 sec)
 */


/*
mysql> DESCRIBE employees;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| id        | int          | NO   | PRI | NULL    |       |
| name      | varchar(255) | YES  |     | NULL    |       |
| job_title | varchar(255) | YES  |     | NULL    |       |
| salary    | double       | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
4 rows in set (0.03 sec)
*/