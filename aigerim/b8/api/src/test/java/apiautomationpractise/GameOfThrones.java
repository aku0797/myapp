package apiautomationpractise;

import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class GameOfThrones {
    @Test
    public void validateCharacterInfo(){
        RestAssured.baseURI="https://thronesapi.com/api/v2";
        RestAssured.basePath="/Characters/10";
        Response response=RestAssured.given().header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .body().statusCode(200).extract().response();

        Map<String, Object> deserializaitonCharac=response.as(new TypeRef<>(){});
        Assert.assertEquals(deserializaitonCharac.get( "firstName"),"Cateyln");
        Assert.assertEquals(deserializaitonCharac.get("lastName"),"Stark");
        Assert.assertEquals(deserializaitonCharac.get("fullName"),"Catelyn Stark");
        Assert.assertEquals(deserializaitonCharac.get("title"),"Lady of Winterfell");
        Assert.assertEquals(deserializaitonCharac.get("family"),"House Stark");



    }
}
