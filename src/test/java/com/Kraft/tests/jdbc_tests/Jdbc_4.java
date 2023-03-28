package com.Kraft.tests.jdbc_tests;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc_4 {

    @Test
    public void listOfMapExample() throws SQLException {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";

        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query2);


        Map<String, Object> row1=new HashMap<>();
        row1.put("employeeId", 99);
        row1.put("firstNAme", "Eren");
        row1.put("lastName", "Çengel");
        row1.put("salary", 100000);

        System.out.println(row1);

        Map<String, Object> row2=new HashMap<>();
        row2.put("employeeId", 1001);
        row2.put("firstNAme", "Alperen");
        row2.put("lastName", "Çengel");
        row2.put("salary", 150000);

        System.out.println(row2);


        List<Map<String,Object>> list=new ArrayList<>();
        list.add(row1);
        list.add(row2);

        System.out.println(list);


    }
    @Test
    public void listOfMapExampleViaDB() throws SQLException {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";

        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query2);


        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

        resultSet.next();
        Map<String, Object> row1=new HashMap<>();
        row1.put(resultSetMetaData.getColumnName(1), resultSet.getString(1));
        row1.put(resultSetMetaData.getColumnName(2), resultSet.getString(2));
        row1.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
        row1.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));
        System.out.println(row1);


        resultSet.next();
        Map<String, Object> row2=new HashMap<>();
        row2.put(resultSetMetaData.getColumnName(1), resultSet.getString(1));
        row2.put(resultSetMetaData.getColumnName(2), resultSet.getString(2));
        row2.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
        row2.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));
        System.out.println(row2);

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        System.out.println(list);

        System.out.println("-----------------------------------");

        System.out.println(list.get(0));

        System.out.println("-----------------------------------");

        System.out.println(list.get(0).get("EMPLOYEEID"));


        resultSet.close();
        statement.close();
        connection.close();


    }


}
