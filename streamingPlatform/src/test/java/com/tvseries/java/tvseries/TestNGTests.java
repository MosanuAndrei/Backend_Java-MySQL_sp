package com.tvseries.java.tvseries;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestNGTests extends AbstractTestNGSpringContextTests{
    
    @Test
    public void checkAddSeries(){
        Response res = RestAssured.given()
            .contentType(ContentType.JSON)
            .body("{"
                + "\"nameSeries\": \"Test Series\"," 
                + "\"numberOfSeasons\": 5," 
                + "\"idCategory\": 1," 
                + "\"idPlatform\": 2" 
                + "}")
            .when().post("http://localhost:8080/series/add").then().extract().response();

        String responseText = res.body().asString();
        Assertions.assertEquals(200, res.getStatusCode());
        assertTrue(responseText.length() > 0);
        res.then().body("success", Matchers.equalTo(true));
    }

    @Test
    public void checkGetAll(){
        Response res = RestAssured.given().get("http://localhost:8080/series/getALL");

        String responseText = res.getBody().asString();
        Assertions.assertEquals(200, res.getStatusCode());
        assertTrue(responseText.length() > 0);
        res.then().body("$.size()", Matchers.greaterThan(0));
    }

    @Test
    public void checkTestNGWorks(){
        Assert.assertTrue(true);
    }

}
