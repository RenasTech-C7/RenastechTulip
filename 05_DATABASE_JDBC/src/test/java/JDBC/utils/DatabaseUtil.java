package JDBC.utils;

import java.sql.*;

public class DatabaseUtil {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection(){

        String url=ConfigReader.getProperties("urlDB");
        String username=ConfigReader.getProperties("username");
        String password=ConfigReader.getProperties("password");

        try{
            connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created");
        }catch (SQLException e){
            System.out.println("Connection is failed");
        }

    }

    public static void closeConnection(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }catch (SQLException s){
            System.out.println("Exception is occurred while closing database");
        }
    }

    public static ResultSet executeQuery(String query){
        try {
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println("An error occurred while executing query");
        }
         return resultSet;

    }
}
