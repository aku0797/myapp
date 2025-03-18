package apiautomationpractise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.StarWarsPojo;

public class Starwars {
    @Test
    public void validateStarwars(){

        RestAssured.baseURI="https://swapi.dev";
        RestAssured.basePath="/api/planets/1";
        Response response=RestAssured.given().header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200).extract().response();
        StarWarsPojo desrializePlanets=response.as(StarWarsPojo.class);
        Assert.assertEquals(desrializePlanets.getName(),"Tatooine");
        Assert.assertEquals(desrializePlanets.getGravity(),"1 standard");
        Assert.assertEquals(desrializePlanets.getTerrain(),"desert");
        Assert.assertEquals(desrializePlanets.getClimate(),"arid");
    }
}
