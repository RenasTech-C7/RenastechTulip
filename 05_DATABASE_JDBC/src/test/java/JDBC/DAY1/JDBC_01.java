package JDBC.DAY1;

import java.sql.*;

public class JDBC_01 {

    public static void main(String[] args) throws SQLException {

        //create connection
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@class-db.ctigbjf2wamf.us-east-1.rds.amazonaws.com:1521:oracle",
                "oraclerenastech","oraclerenastech");

        //create statement
        Statement statement = connection.createStatement();

        //execute query and store it into resultSet
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

        //move cursor to next row
        resultSet.next();


        System.out.println("First column value: " + resultSet.getString(1));
        System.out.println("The phone number in first row: " + resultSet.getString("phone_number"));

         /* connection.close();
          statement.close();
          resultSet.close();*/

    }
}
