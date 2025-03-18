package apiautomationpractise;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BookingPojo;
import pojo.StarWarsPojo;

import java.util.Map;

public class BookingInfo {
    @Test
    public void validateBookingInfo() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/984";
        Response response = RestAssured.given().header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log().body().statusCode(200).extract().response();
        Map<String, Object> deserializatedData = response.as(new TypeRef<>() {
        });
        System.out.println(deserializatedData);
        Assert.assertEquals(deserializatedData.get("firstname"), "Josh");
        Assert.assertEquals(deserializatedData.get("lastname"), "Allen");
        Assert.assertEquals(deserializatedData.get("totalprice"), 111);
        Assert.assertEquals(deserializatedData.get("depositpaid"), true);
        Assert.assertEquals(deserializatedData.get("additionalneeds"), "super bowls");
        Map<String, Object> bookingtime = (Map<String, Object>) deserializatedData.get("bookingdates");
        System.out.println(bookingtime);
        Assert.assertEquals(bookingtime.get("checkin"), "2018-01-01");

    }
    @Test
    public void validateBookingWithPojo(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/2538";
        Response response = RestAssured.given().header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log().body().statusCode(200).extract().response();
       // Map<String, Object> deserializatedData = response.as(new TypeRef<>() {
       // });
        BookingPojo deserializedResponse=response.as(BookingPojo.class);
       Assert.assertEquals(deserializedResponse.getFirstname(),"Jerry");
       Assert.assertEquals(deserializedResponse.getLastname(),"Tom");
       Assert.assertEquals(deserializedResponse.getTotalprice(),1131);
       Assert.assertEquals(deserializedResponse.getAdditionalneeds(),"Breakfast");
       Assert.assertTrue(deserializedResponse.isDepositpaid());
       Assert.assertEquals(deserializedResponse.getBookingdates().getCheckin(),"2025-01-05");
        Assert.assertEquals(deserializedResponse.getBookingdates().getCheckout(),"2025-01-10");

    }
    @Test
    public void validateStarwars(){

        RestAssured.baseURI="https://swapi.dev/api/";
        RestAssured.basePath="planets/1";
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
    }
}
