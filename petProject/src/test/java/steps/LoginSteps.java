package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import utillities.Config;
import utillities.Driver;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(Config.getProp("sauceDemo"));
    }


    @When("user provides a valid username")
    public void user_provides_a_valid_username() {
        loginPage.usernameInputField.sendKeys(Config.getProp("username"));

    }

    @When("user provides a valid password")
    public void user_provides_a_valid_password() {
        loginPage.passwordInputField.sendKeys(Config.getProp("password"));

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify user logged in")
    public void verify_user_logged_in() {
        String expectedURL="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
    }


}
