package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAndOrOperators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");


        WebElement firstName= driver.findElement(By.xpath("//input[@id='firstName']"));
firstName.sendKeys("Aigerim");

WebElement lastname=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

lastname.sendKeys("Rakhatbeokva");
        Thread.sleep(2000);

WebElement femaleGender= driver.findElement(By.xpath("//label [text()='Female']"));
femaleGender.click();

WebElement dateOfBirth= driver.findElement(By.xpath("//div[@aria-label='Choose Monday, July 14th, 1997']"));
dateOfBirth.click();
    }
}
