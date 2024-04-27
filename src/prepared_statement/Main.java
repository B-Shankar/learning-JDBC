package prepared_statement;

import java.sql.*;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "000000";
        String query = "select * from employees where name = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully!");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected Established Successfully!");
//            Statement statement = connection.createStatement(); //normal Statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "Kunal");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID : " + id);
                System.out.println("NAME : " + name);
                System.out.println("JOB TITLE : " + job_title);
                System.out.println("SALARY : " + salary);
            }

            resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection Closed Successfully!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
