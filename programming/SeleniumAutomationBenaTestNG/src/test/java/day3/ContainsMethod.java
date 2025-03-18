package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ContainsMethod {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");



        List<WebElement> usersElements=driver.findElements(By.xpath("//input[contains(@id,'user')]"));
        System.out.println(usersElements.size());
usersElements.get(0).sendKeys("AKu");
usersElements.get(1).sendKeys("aigerim@gmail.com");

WebElement user=usersElements.get(0);

    }
}
