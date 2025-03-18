package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
//
//driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//driver.findElement(By.id("password")).sendKeys("secret_sauce");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement lginButton = driver.findElement(By.id("login-button"));
        lginButton.click();


        WebElement bikeLightButton = driver.findElement(By.id("add-to-cart"));
        bikeLightButton.click();

        WebElement TshirtButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        TshirtButton.click();

        Thread.sleep(5000);
    }
}
