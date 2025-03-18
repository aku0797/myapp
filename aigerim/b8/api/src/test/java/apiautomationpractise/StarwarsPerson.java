package apiautomationpractise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.StarWarPersonPojo;

public class StarwarsPerson {
    @Test
    public void validatePersonDetails(){
        RestAssured.baseURI="https://swapi.dev";
        RestAssured.basePath="/api/people/1";
        Response response=RestAssured.given().header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log().body().statusCode(200).extract().response();

        StarWarPersonPojo deserData=response.as(StarWarPersonPojo.class);
        Assert.assertEquals(deserData.getName(),"Luke Skywalker");
        Assert.assertEquals(deserData.getGender(),"male");
        Assert.assertEquals(deserData.getHair_color(),"blond");


    }
}
