package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

public class Tag_steps {
    RequestSpecification request;
    Response response;

    JSONObject requestBody = new JSONObject();

    @Given("base url {string}")
    public void base_url(String url) {
        request = RestAssured.given().
                baseUri(url);
    }

    @When("i provide valid authorization token")
    public void i_provide_valid_authorization_token( ) {
        request = request.auth().oauth2("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3Mzg4MjgwODAsImlhdCI6MTczNjIzNjA4MCwidXNlcm5hbWUiOiJudXJlZWJlckBnbWFpbC5jb20ifQ.Gx1wlWGwD3T1FPnep_0kXmZHagdfoTZTOQQkoiJ99Y5WjZM0GlFPuNf8gz4R5O6o6aXjgASmlEtjy7eSa_jGgw");
    }

    @When("i provide {string} with {string}")
    public void i_provide_with(String key, String value) {
        requestBody.put(key, value);
        request = request.body(requestBody.toString());
    }

    @When("i hit POST endpoint {string}")
    public void i_hit_post_endpoint(String endpoint) {
    response = request.post(endpoint);
    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer statusCode) {
        System.out.println(response.prettyPrint());

        Assert.assertEquals((int)statusCode,response.statusCode());
    }

    @Then("verify response body contains {string} with {string}")
    public void verify_response_body_contains_with(String key, String value) {
      String expectedValue=    response.jsonPath().get(key);

      Assert.assertEquals(expectedValue,value);


    }


}
