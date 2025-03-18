package apiautomationpractise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PetsPojo;

public class PetStore {
    @Test
    public void validatePetInfo() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";

        Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body("{\n" + "  \"id\": 93,\n" + "  \"category\": {\n" + "    \"id\": 5,\n" + "    \"name\": \"Taygan\"\n" + "  },\n" + "  \"name\": \"doggie\",\n" + "  \"photoUrls\": [\n" + "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 0,\n" + "      \"name\": \"string\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"available\"\n" + "}").when().post().then().log().body().statusCode(200).extract().response();


        PetsPojo deserializePet = response.as(PetsPojo.class);
        //main pojo
        Assert.assertEquals(deserializePet.getId(), 93);
        Assert.assertEquals(deserializePet.getName(), "doggie");
        // Assert.assertEquals(deserializePet.getPhotoUrls().get(0), "string");
        Assert.assertEquals(deserializePet.getStatus(), "available");

        //category pojo
        Assert.assertEquals(deserializePet.getCategory().getId(), 5);
        Assert.assertEquals(deserializePet.getCategory().getName(), "Taygan");
        //tags pojo
        Assert.assertEquals(deserializePet.getTags().get(0).getName(), "string");


    }

    @Test
    public void validateFindingPetEndPointWithJSONPath() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/93";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get().then().log().body().statusCode(200).extract().response();
        JsonPath desrializResponse = response.jsonPath();

        Assert.assertEquals(desrializResponse.get("name"), "doggie");



    }
    @Test
    public void updatePetsInfo(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" + "  \"id\": 93,\n" + "  \"category\":" +
                        " {\n" + "    \"id\": 5,\n" + "  " +
                        "  \"name\": \"Ovcharka\"\n" + "  },\n" + " " +
                        " \"name\": \"Kuchuk\",\n" + " " +
                        " \"photoUrls\": [\n" + "   " +
                        " \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "  " +
                        "  {\n" + "      \"id\": 0,\n" + "     " +
                        " \"name\": \"dog\"\n" + "    }\n" + "  ],\n" + " " +
                        " \"status\": \"available\"\n" + "}")
                .when().put().then().log().body().statusCode(200).extract().response();


        PetsPojo deserializePet2 = response.as(PetsPojo.class);

        Assert.assertEquals(deserializePet2.getName(),"Kuchuk");
        Assert.assertEquals(deserializePet2.getCategory().getName(),"Ovcharka");
        Assert.assertEquals(deserializePet2.getTags().get(0).getName(), "dog");


    }

}
