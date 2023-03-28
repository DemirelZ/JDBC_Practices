package com.Kraft.tests.api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class testWithPathParameters {

//TASK
//base url = https://gorest.co.in/
//end point = /public/v2/users
//path parameter = {id} --> 206601
//send a get request with the above credentials
//verify that the body below
    /*
    {
    "id": 206601,
    "name": "Suryakanta Guha",
    "email": "guha_suryakanta@streich.com",
    "gender": "male",
    "status": "active"
    }
     *
     */

    @Test
    public void test1(){



    }

//============================================================================================

    /*
    baseUrl = https://www.krafttechexlab.com/sw/api/v1
    endpoint = /allusers/getbyid
 Given accept type is json
 and path param is 1
 when user sends GET request to /allusers/getbyid/{id}
 then status code should be 200
 and response content type:application/json;charset=UTF-8
 and response payload values match the following
    id is 1
    name is "aFm"
    email is "afmercan@gmail.com"
    about is "About"
    terms is "16"
  */
    @Test
    public void test2(){

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", 1)
                .when()
                .get("https://www.krafttechexlab.com/sw/api/v1/allusers/getbyid/{id}");

        int id=response.path("id[0]");
        String name=response.path("name[0]");
        String email=response.path("email[0]");

        Assert.assertEquals(id, 1);
        Assert.assertEquals(name, "MercanS");
        Assert.assertEquals(email, "afmercan@gmail.com");


    }


}
