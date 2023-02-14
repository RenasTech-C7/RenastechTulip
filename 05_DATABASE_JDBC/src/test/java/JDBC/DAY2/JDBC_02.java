package JDBC.DAY2;

import JDBC.utils.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
//ResultSetMetaData an object that is used to get information about the properties of columns
// such as column names, count of columns, types
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        System.out.println("Column index is: " + resultSet.getFetchSize());

        //in order to get column count we need to use resultSetMetaData
        System.out.println("Column's size is: " +resultSetMetaData.getColumnCount());

        //print name of the 2nd column
        String columnName=resultSetMetaData.getColumnName(2);
        System.out.println(columnName);
        System.out.println("----------------Print all column names with for loop-------------");
         int columnCount=resultSetMetaData.getColumnCount();
         for (int i=1; i<=columnCount;i++){
             System.out.println(resultSetMetaData.getColumnName(i) + "\t");
         }
        System.out.println("----------------Print all column names with ArrayList-------------");
        List<String> employeesColumnNames= new ArrayList<>();
        for (int i=1; i<=columnCount;i++){
            employeesColumnNames.add(resultSetMetaData.getColumnName(i));
        }
        System.out.println(employeesColumnNames);
        DatabaseUtil.getAllData();




    }
    @Test
    public void Test2() throws SQLException {
        String job="Manager";

        ResultSet resultset=DatabaseUtil.updateQuery("update renasc7 set jobs='"+job+"' where personid=167");




    }


}
