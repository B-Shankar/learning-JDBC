package prepared_statement;

import java.sql.*;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "000000";
        String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully!");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected Established Successfully!");

            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            input.nextLine();
            String name = input.nextLine();
            String job_title = input.nextLine();
            Double salary = input.nextDouble();

            PreparedStatement preparedStatement =  con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, job_title);
            preparedStatement.setDouble(4, salary);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Data Inserted Successfully!");
            }else {
                System.out.println("Data Insertion Failed!");
            }

            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection Closed Successfully!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
