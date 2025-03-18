package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionPractice {
    @Test
    public void test1() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://magneto.softwaretestingboard.com/");
        WebElement women = driver.findElement(By.xpath("//span[text()=Women'].."));
        WebElement womentops = driver.findElement(By.id("ui-id-9"));

        WebElement teees = driver.findElement(By.id("ui-id-13"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women)
                .moveToElement(womentops)
                .click()
                .build().perform();

    }
}