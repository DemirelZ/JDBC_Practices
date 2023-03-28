package com.Kraft.tests.jdbc_tests;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc_5_DinamikListe {

    @Test
    public void dynamicList() throws SQLException {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";

        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query2);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String, Object>> list = new ArrayList<>();

        while (resultSet.next()) {

            Map<String, Object> map = new HashMap<>();

            for (int i = 1; i < resultSetMetaData.getColumnCount() + 1; i++) {
                map.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
            }
            list.add(map);
        }

        System.out.println(list);









        resultSet.close();
        statement.close();
        connection.close();


    }
}
