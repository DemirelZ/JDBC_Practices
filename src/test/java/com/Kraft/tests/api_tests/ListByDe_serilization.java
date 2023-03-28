package com.Kraft.tests.api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class ListByDe_serilization {

    // TASK
    // base url = https://gorest.co.in/
    // endpoint = /public/v2/users
    // send the GET request, get the all data into a list by de-serilization

    @Test
    public void test1(){

        Response response= RestAssured
                .when()
                .get("https://gorest.co.in/pub");

    }


}
