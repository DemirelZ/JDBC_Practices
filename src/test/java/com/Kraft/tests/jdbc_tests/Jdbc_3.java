package com.Kraft.tests.jdbc_tests;

import org.junit.Test;

import java.sql.*;

public class Jdbc_3 {



    @Test
    public void someMethotForMovingCursor() throws SQLException {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";

        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query2);

        //ResultSet.TYPE_SCROLL_INSENSITIVE --> pointer ile serbestcce aşağı yukarı gidebilir
        // ResultSet.CONCUR_READ_ONLY --> read only, do not database

        resultSet.next();
        resultSet.next();
        //hangi satırdayım
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //kaç satır old nasıl öğreneceğim
        resultSet.last();
        System.out.println(resultSet.getRow());

        //bir önceki satıra nasıl giderim
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //beforefirs (sütun isimlerinin old satıra gitme)
        resultSet.beforeFirst();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        resultSet.next();
        resultSet.afterLast();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //absolute
        resultSet.absolute(10);
        System.out.println("resultSet.getRow() = " + resultSet.getRow());




    }
    @Test
    public void databaseMEtaDAtaExample() throws SQLException {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";

        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query2);

        DatabaseMetaData databaseMetaData= connection.getMetaData();
        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());


    }
    @Test
    public void resultSetMEtaDAtaExample() throws SQLException {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";

        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query2);

        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

        //sütun sayısı
        System.out.println("resultSetMetaData.getColumnCount() = " + resultSetMetaData.getColumnCount());

        //sütun isimleri
        System.out.println("resultSetMetaData.getColumnName(6) = " + resultSetMetaData.getColumnName(6));

        System.out.println("-------------------------------------------------");

        //bütün sütun isimlerini dinamik olarak getir
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println(i+". column = " + resultSetMetaData.getColumnName(i));
        }
        System.out.println("..................................................");
        while(resultSet.next()){
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                System.out.print(resultSet.getString(i)+" ");
            }
            System.out.println();

        }


    }


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";
        String query = "select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2 = "select * from employeesEren";
        String query3 = "select email from employeesEren";


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query2);

        resultSet.next();

        System.out.println(resultSet.getString(1));



        ResultSetMetaData metaData=resultSet.getMetaData();

        resultSet.close();
        statement.close();
        connection.close();


    }


}
