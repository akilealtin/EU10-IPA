package com.cybertek.Week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {
    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://34.234.234.150:8000/api/spartans");
        System.out.println(response.statusCode());
        Assertions.assertEquals(200, response.statusCode(), "Test status code");

        Assertions.assertEquals("application/json", response.header("content-type"));
        response.prettyPrint();
        Assertions.assertEquals("application/json", response.contentType());


    }

    //get single spartan
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://34.234.234.150:8000/api/spartans");
        System.out.println(response.statusCode());
        response.prettyPrint();

        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        Assertions.assertEquals(30, response.path("id").toString());
        Assertions.assertEquals("Melania", response.path("name").toString());

    }
    @Test
    public void test3() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains","Da")
                .when().get("http://34.234.234.150:8000/api/search");
        System.out.println(response.statusCode());
        response.prettyPrint();

    }
}
