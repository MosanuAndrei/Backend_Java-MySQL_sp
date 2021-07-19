package com.tvseries.java.tvseries;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
public class JUnitTests {
    
    @Test
    public void checkGetByCategory(){
        Response res = RestAssured.given().get("http://localhost:8080/series/getByCategory/Action");

        String responseText = res.getBody().asString();
        
        Assertions.assertEquals(200, res.getStatusCode());
        assertTrue(responseText.length() > 0);
        res.then().body("$.size()", Matchers.greaterThan(0));
    }

    @Test
    public void checkUpdateCategory(){
        Response res = RestAssured.given().contentType(ContentType.JSON)
                        .body("{"
                        + "\"nameCategory\": \"Adventure\"" 
                        + "}")
                        .put("http://localhost:8080/category/update/1");

        String responseText = res.getBody().asString();
        Assertions.assertEquals(200, res.getStatusCode());
        assertTrue(responseText.contains("Success!"));;
    }

    @Test
    public void checkJunitWorks(){
        assertTrue(true);
    }
}
