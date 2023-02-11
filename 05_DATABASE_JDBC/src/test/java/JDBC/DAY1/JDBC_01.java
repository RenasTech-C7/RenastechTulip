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



        //bring second row's first_name and last_name
        resultSet.next();
        System.out.println("First name: " + resultSet.getString("first_name") + "\n" + "Last Name: " +
                resultSet.getString(3));



          //bring all information of third row
        resultSet.next();
        //we can not get all the column name's size with resultSet.getFetchSize();, we need to use ResultSetMetadata
        //resultSet.getFetchSize();
        for (int i=1 ; i<=11 ; i++){
            System.out.print(resultSet.getString(i));
            System.out.print(" ");
        }


        connection.close();
        statement.close();
        resultSet.close();

    }
}
