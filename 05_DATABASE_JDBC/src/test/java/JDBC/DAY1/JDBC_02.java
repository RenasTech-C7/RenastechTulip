package JDBC.DAY1;

import java.sql.*;

public class JDBC_02 {

    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@class-db.ctigbjf2wamf.us-east-1.rds.amazonaws.com:1521:oracle";
        String username = "oraclerenastech";
        String password = "oraclerenastech";
        Connection connection=null;

        try {
           connection= DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connection is created");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection is failed");
        }

        Statement statement=connection.createStatement();

        ResultSet resultSet=statement.executeQuery("Select * from Employees");

     //while loop will bring all specified column's rows value
        while (resultSet.next()){
            System.out.println(resultSet.getString("first_name") + ": Salary -> " + resultSet.getString("salary"));
        }

        connection.close();
        statement.close();
        resultSet.close();

    }
}
