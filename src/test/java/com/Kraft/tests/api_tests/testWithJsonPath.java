package com.Kraft.tests.api_tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class testWithJsonPath {



    @Test
    public void test1(){

        Response response = given()
                .queryParam("page", 1)
                .queryParam("pagesize", 10)
                .when()
                .get("https://www.krafttechexlab.com/sw/api/v1/allusers/alluser");

        response.then().statusCode(200);

        JsonPath jsonPath=response.jsonPath();

        int id = jsonPath.getInt("id[0]");
        System.out.println("id = " + id);

        List<String> names = jsonPath.getList("name");
        System.out.println("names = " + names);

        List<String> skills = jsonPath.getList("skills[0]");

        System.out.println("skills = " + skills);

        String skl1 = jsonPath.getString("skills[0][1]");
        System.out.println("skl1 = " + skl1);

        String okul = jsonPath.getString("education[0].school[1]");
        System.out.println("okul = " + okul);

        Map<String, Object> map = jsonPath.getMap("education[0][0]");

        System.out.println("map = " + map);

        System.out.println("map.get(\"id\") = " + map.get("id"));

    }

}
