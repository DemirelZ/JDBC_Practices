package com.Kraft.tests.jdbc_tests;

import java.sql.*;

public class Jdbc_1 {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";
        String query = "select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2 = "select * from employeesEren";

        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet=statement.executeQuery(query2);

        //sütun sayıları 1 den başlar

        //ilgili sütuna index number ile ulaşma
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(3));
        System.out.println();
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(3));
        System.out.println();

        //ilgili sütun adı ile ulaşma
        resultSet.next();
        resultSet.getString("email");






        resultSet.close();
        statement.close();
        connection.close();

    }

}
