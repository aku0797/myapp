package apiautomationpractise;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FakeProductInfo {
    @Test
    public void validateProductInfo(){
        RestAssured.baseURI="https://fakestoreapi.com";
        RestAssured.basePath="/products/1";//end point
      Response response=RestAssured.given().header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .body().statusCode(200).extract().response();

      // deserialization (the most asked interview question) //type ref
        Map<String, Object> deserializedResponse=response.as(new TypeRef<>(){});
        System.out.println(deserializedResponse);

        Assert.assertEquals(deserializedResponse.get("id"),1);
        Assert.assertEquals(deserializedResponse.get("price"),109.95);
        Assert.assertEquals(deserializedResponse.get("category"),"men's clothing");
        Assert.assertTrue(deserializedResponse.get("title").toString().contains("Fjallraven"));
        Assert.assertTrue(deserializedResponse.get("description").toString().contains("Your perfect"));
        Assert.assertEquals(deserializedResponse.get("image"),"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
        Map <String, Object> ratingdates= (Map<String, Object>) deserializedResponse.get("rating");
        System.out.println(ratingdates);
        Assert.assertEquals(ratingdates.get("rate"),3.9);





    }
}
