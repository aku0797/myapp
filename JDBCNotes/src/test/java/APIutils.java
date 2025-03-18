import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIutils {

    
    public static String getToken(){
        String endpoint="https://backend.cashwise.us/api/myaccount/auth/login";

//        requestBody.put("aigerimrakhatbekova15@gmail.com", "Akusha001007_");  JSON object
//        request = request.body(requestBody.toString());

        RequestBody requestBody= new RequestBody();
        requestBody.setEmail("aigerimrakhatbekova15@gmail.com");
        requestBody.setPassword("Akusha001007_");

        Response response= RestAssured.given().contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpoint);
        return  response.jsonPath().getString("jwt_token");
    }

}
