package com.Kraft.tests.jdbc_tests;

import java.sql.*;

public class Jdbc_2 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";
        String query = "select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2 = "select firstName, lastName from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet=statement.executeQuery(query2);

        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString("lastName"));

        System.out.println("-----------------------------------");

        //farklı queryler kullanabiliriz
        ResultSet resultSet1=statement.executeQuery(query3);
        resultSet1.next();
        System.out.println(resultSet1.getString(1));


        resultSet.close();
        statement.close();
        connection.close();


    }
}
