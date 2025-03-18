import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class Steps {

    Logger logger = LogManager.getLogger(Steps.class);
    RequestSpecification request;
    JSONObject requestbody = new JSONObject();
    Response response;


    @Given("base url {string}")
    public void base_url(String baseurl) {
        requestbody = (JSONObject) RestAssured.given()
                .baseUri(baseurl).contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    @Given("user has endpoint {string}")
    public void user_has_endpoint(String endpoint) {
        request= request.basePath(endpoint);
    }

    @When("user provides valid token")
    public void user_provides_valid_token() {

    }

    @When("user provides request body with {string} and {string}")
    public void user_provides_request_body_with_and(String key, String value) {

    }

    @Then("user hits POST request")
    public void user_hits_post_request() {
    }

    @Then("verify status code {int}")
    public void verify_status_code(Integer statuscode) {

    }

}
