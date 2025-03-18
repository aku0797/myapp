package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sausedemotest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username= driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginbutton=driver.findElement(By.id("login-button"));
        loginbutton.click();

String url= driver.getCurrentUrl();
        System.out.println(url);
        WebElement menubutton= driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']"));
        menubutton.click();
        Thread.sleep(3000);
WebElement aboutbutton=driver.findElement(By.xpath("//*[@href='https://saucelabs.com/']"));
aboutbutton.click();
String url2= driver.getCurrentUrl();
if (url2.contains("https://saucelabs.com")){
    System.out.println(url2 +"success");
}else{
    System.out.println("Fail");
}

    }
}
