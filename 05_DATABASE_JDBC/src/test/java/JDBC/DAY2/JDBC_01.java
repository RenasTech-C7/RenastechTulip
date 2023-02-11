package JDBC.DAY2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBC_01 {


    /*
    RESULTSET METHODS
    * next() -> moves to the next row
    * previous() -> moves to previous row
    * first() -> jumps to the first row
    * last() -> jumps to the last row
    * absolute(int row) -> go to the specific rows
    * beforeFirst() -> jumps to row(). Used to call next method in the while loop
    * getRow() -> returns the index of current row
    *getObject(columnLabel/index) -> reads the data from column
    */

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    @BeforeEach
    public void connectDB(){
        String dbUrl = "jdbc:oracle:thin:@class-db.ctigbjf2wamf.us-east-1.rds.amazonaws.com:1521:oracle";
        String username = "oraclerenastech";
        String password = "oraclerenastech";
        try {
            connection= DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connection is created");
        } catch (SQLException e) {
            System.out.println("Connection is failed");
            throw new RuntimeException(e);
        }
    }
    @AfterEach
    public void closeDB() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }

    @Test
    public void test1() throws SQLException {
        //ResultSet.TYPE_SCROLL_INSENSITIVE will make your cursor free
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery("Select * from Countries");

        //1st row
        resultSet.next();
        System.out.println("I'm in first row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        //2nd row
        resultSet.next();
        System.out.println("I'm in second row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        //it'll go to previous row
        resultSet.previous();
        System.out.println("I'm in first row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        resultSet.next();
        System.out.println("I'm in second row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        resultSet.next();
        System.out.println("I'm in third row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        resultSet.first();
        System.out.println("I'm in " + resultSet.getRow() + "st row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        resultSet.next();
        System.out.println("I'm in " + resultSet.getRow() + "nd row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));

        resultSet.beforeFirst();
        //resultSet.beforeFirst(); will go to above first row and it'll not read it
        /*System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));*/
        //in order to solve it we need to move cursor
        resultSet.next();
        System.out.println("I'm in " + resultSet.getRow() + "st row");
        System.out.println("Country ID: " +resultSet.getString(1) + "\n"
                + "Country Name: " + resultSet.getString("Country_name"));
        resultSet.next();
        resultSet.next();
        resultSet.next();
        //this will bring from 5th row to the end
        while (resultSet.next()){
            System.out.println(resultSet.getString("Country_name"));
        }
        resultSet.beforeFirst();
        System.out.println();
        System.out.println("After using resultSet.beforeFirst() ");
        //this will bring all info from beginning
        while (resultSet.next()){
            System.out.println(resultSet.getString("Country_name"));
        }


    }
}
