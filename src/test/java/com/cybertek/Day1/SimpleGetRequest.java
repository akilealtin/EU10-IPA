package com.cybertek.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    String url="http://34.234.234.150:8000/api/spartans";
    @Test
    public void test1(){
        //sen a get request and save response inside the object
        Response response = RestAssured.get(url);
        // print response status code
        System.out.println(response.statusCode());

    }
}
