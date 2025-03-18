package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemoTest {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.get("https://blazedemo.com/");
        WebElement destinationoftheweekButton= driver.findElement(By.xpath(""));
        destinationoftheweekButton.click();
        String url= driver.getCurrentUrl();
        System.out.println(url);

        WebElement destinationtext= driver.findElement(By.xpath(""));
        String text=destinationtext.getText();

        if (text.contains("Hawaii")){
            System.out.println("pass");
        }else {
            System.out.println("FAIL");
        }
driver.quit();
    }
}
