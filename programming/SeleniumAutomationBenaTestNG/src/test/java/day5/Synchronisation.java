package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronisation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.xpath("//input[@id='user-name']"));
        login.sendKeys("standard_user");
        WebElement passwoord = driver.findElement(By.xpath("//input[@id='password']"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce"+ Keys.ENTER);

      //  passwoord.sendKeys("secret_sauce");
        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
      //  loginbutton.click();

    }
}
