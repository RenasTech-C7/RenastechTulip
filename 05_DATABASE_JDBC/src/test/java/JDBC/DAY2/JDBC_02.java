package JDBC.DAY2;

import JDBC.utils.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC_02 extends DatabaseUtil {


    @BeforeEach
    public void startConnection(){
        DatabaseUtil.createConnection();
    }
    @AfterEach
    public void tearDown(){
        DatabaseUtil.closeConnection();
    }

    @Test
    public void Test1() throws SQLException {
        ResultSet resultSet=DatabaseUtil.executeQuery("Select * from employees");
        resultSet.next();
        System.out.println("First Name: " + resultSet.getString("first_name"));

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        System.out.println("Column index is: " + resultSet.getFetchSize());

        System.out.println("Column's size is: " +resultSetMetaData.getColumnCount());

        //print name of the 2nd column
        String columnName=resultSetMetaData.getColumnName(2);
        System.out.println(columnName);
        System.out.println("Print all column names");




    }


}
