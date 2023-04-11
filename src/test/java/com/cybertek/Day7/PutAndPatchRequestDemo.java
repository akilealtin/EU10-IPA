package com.cybertek.Day7;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class PutAndPatchRequestDemo extends SpartanTestBase {

    @DisplayName("PUT request to one spartan for update with Map")
    @Test
    public void PUTRequest() {
        //just like post request we have different options to send body, we will go with map
        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name", "BruceWayne");
        putRequestMap.put("gender", "Male");
        putRequestMap.put("phone", 8811111111L);
        //even I update one field, I need to write them all.

        //serialization  (map(java) to json body)
        given().contentType(ContentType.JSON) //hey api I am sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id", 100)
                .when().put("/api/spartans/{id}")
                .then()
                .statusCode(204);

        /*
Whenever we are sending request Body as a JSON(POST,PUT,PATCH) we need to tell api
we that jsonBody attached and the way is content-type,application/json header
if we are not getting any json body in return, we do not need to specify accept type bc the reason is we got 204,
not json body. accepts tells we want json body. if there is no body why should I ask Json ?
         */

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

        // putRequestMap.get("phone"),spartan.getPhone

    }

/*
Different between put and patch
Everything is same, only difference is patch is more flexible
in patch you can remove the fields that you are not updating.
you can write only what field you update.
like partial update
 */

    @DisplayName("PATCH request to one spartan for partial update with Map")
    @Test
    public void PATCHRequest() {
        //just like post request we have different options to send body, we will go with map
        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("phone", 8811111111L);
        putRequestMap.put("name", "Peter");

        //whatever I give as a Map will be serializa

        given().contentType(ContentType.JSON) //hey api I am sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id", 100)
                .when().patch("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send


    }


    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan() {
        int idToDelete = 100;


        given().pathParam("id", idToDelete)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);

        //send a get request after you delete make sure you are getting 404


    }

}
