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

    public static int getCountColumn(){
        int columnCount=0;
        try {
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            columnCount=resultSetMetaData.getColumnCount();
        }catch (SQLException s){
            System.out.println("An error occured while getting column count");
        }
        return  columnCount;

    }

    public static void getAllData(){

        try{
            int columnCount=getCountColumn();
            resultSet.beforeFirst();
            while (resultSet.next()){
                for (int i=1 ; i<=columnCount; i++){
                    System.out.print(resultSet.getString(i) + "\t" + "\t");
                }
                System.out.println();
            }
            resultSet.beforeFirst();
        }catch (SQLException e){
            System.out.println("An error occurred");
        }

    }
     public static ResultSet updateQuery(String query){
         try {
             statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             int resultSet=statement.executeUpdate(query);
             if (resultSet>0){
                 System.out.println("Updated or Inserted");
             }else {
                 System.out.println("Nothing has changed");
             }
         }catch (SQLException e){
             System.out.println("An error occurred while executing query");
         }
         return resultSet;

     }

}
