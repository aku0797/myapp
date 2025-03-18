package apiautomationpractise;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.when;

public class Authorization {
    @Test
    public void validateAuthorization() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "auth";

        Response response = RestAssured.given().header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" :\"password123\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        Map<String, Object> deserializationAuth = response.as(new TypeRef<>() {
        });
        Assert.assertNotNull(deserializationAuth.get("token"));

    }

    @Test
    public void validateCreateBooking() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";
        Response response = RestAssured.given().header("Content-Type", "application/json").header("Accept", "application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Jerry\",\n" +
                        "    \"lastname\" : \"Tom\",\n" +
                        "    \"totalprice\" : 1131,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2025-01-05\",\n" +
                        "        \"checkout\" : \"2025-01-10\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}"
                )
                .when()
                .post()
                .then()
                .log().body().statusCode(200).extract().response();

        Map<String, Object> deserBody = response.as(new TypeRef<>() {
        });
        Map<String, Object> bookingId = response.as((Type) deserBody.get("booking"));
        Map<String, Object> checkinDates = response.as((Type) deserBody.get("bookingdates"));
        Assert.assertNotNull(bookingId.get("id"));
        Assert.assertEquals(checkinDates.get("checkin"), "2025-01-05");


/*
1-Automate the create endpoint
2-Deserialized the response
3-validate the id is not null
4-validate the firstname,lastname and checkin
 */
    }

    @Test
    public void validateAUTHO() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/{id}";
        Response response = RestAssured.given().header("Content-Type", "application/json").header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .pathParams("id", "631")
                .body("{\\n\" +\n" +
                        "                \"    \\\"firstname\\\" : \\\"Hailey1\\\",\\n\" +\n" +
                        "                \"    \\\"lastname\\\" : \\\"Tommy\\\",\\n\" +\n" +
                        "                \"    \\\"totalprice\\\" : 1131,\\n\" +\n" +
                        "                \"    \\\"depositpaid\\\" : true,\\n\" +\n" +
                        "                \"    \\\"bookingdates\\\" : {\\n\" +\n" +
                        "                \"        \\\"checkin\\\" : \\\"2025-01-05\\\",\\n\" +\n" +
                        "                \"        \\\"checkout\\\" : \\\"2025-01-10\\\"\\n\" +\n" +
                        "                \"    },\\n\" +\n" +
                        "                \"    \\\"additionalneeds\\\" : \\\"Breakfast\\\"\\n\" +\n" +
                        "                \"}")
                .when().put().then().log().body()
                .statusCode(200)
                .extract()
                .response();


    }

    @Test
    public void validateContinents() {
        RestAssured.baseURI = "https://thronesapi.com/api/v2";
        RestAssured.basePath = "/Continents";
        Response response = RestAssured.given().header("Content-Type", "application/json").header("Accept", "application/json")
                .when().get()
                .then().log().body().statusCode(200).extract().response();
        List<Map<String, Object>> deserializeObject = response.as(new TypeRef<>() {
        });
        Assert.assertEquals(deserializeObject.size(), 4);
        List<String> expectedContinents = Arrays.asList("Westeros", "Essos", "Sothoryos", "Ulthos");
        for (int i = 0; i < expectedContinents.size(); i++) {
            Assert.assertEquals(deserializeObject.get(i).get("name"), expectedContinents.get(i));

        }

    }


    @Test
    public void validateCatFactsInformation(){
        RestAssured.baseURI="https://catfact.ninja";
        RestAssured.basePath="facts";

        Response response=RestAssured.given().header("Accept","application/json")
                .queryParam("limit",332)
                .when()
                .get()
                .then().log().body().statusCode(200).extract().response();
        //Deserialization
        Map<String,Object> deserializedResponse=response.as(new TypeRef<Map<String, Object>>() {});

        Assert.assertEquals(deserializedResponse.get("current_page"),1);

        List<Map<String,Object>> allData= (List<Map<String, Object>>) deserializedResponse.get("data");

        int moreThan50=0;
        int lessThan200=0;
        int more50Less200=0;
        int containsCat=0;

        for(Map<String,Object> data:allData){

            if(Integer.parseInt(data.get("length").toString())>50){
                moreThan50++;
            }
            if(Integer.parseInt(data.get("length").toString())<200){
                lessThan200++;
            }
            if(Integer.parseInt(data.get("length").toString())>50 && Integer.parseInt(data.get("length").toString())<200){
                more50Less200++;
            }
            if(!data.get("fact").toString().toLowerCase().contains("cat") ){
                containsCat++;
            }
        }
        Assert.assertEquals(moreThan50,299);
        Assert.assertEquals(lessThan200,293);
        Assert.assertEquals(more50Less200,260);
        Assert.assertEquals(containsCat,25);
    }
}
/*
1-Call the endpoint
2-Count How many of them has more than 50 length --> 299
3-Count How many of them has less than 200 length -->293
4-Count How many of them more than 50 and less than 200 at the same time -->260
5-Count How many of them not contains cat in facts. -->25
 */
