package com.Kraft.tests.jdbc_tests;

import com.Kraft.utilities.DBUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Jdbc_6_DBUtils {


    @Test
    public void test1() {

        DBUtils.createConnection();
        List<List<Object>> queryResultList = DBUtils.getQueryResultList("select * from employeesEren");
        System.out.println(queryResultList);
        DBUtils.destroy();

    }

    @Test
    public void test2() {

        DBUtils.createConnection();
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("select * from employeesEren");
        System.out.println(queryResultMap);
        DBUtils.destroy();

    }

}
