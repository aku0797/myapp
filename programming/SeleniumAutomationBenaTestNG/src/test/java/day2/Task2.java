package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
                driver.get("https://the-internet.herokuapp.com/");
                String url= driver.getCurrentUrl();
        System.out.println(url);

       String title= driver.getTitle();
        System.out.println(title);
        WebElement checkbox= driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkbox.click();
        String url2= driver.getCurrentUrl();
        System.out.println(url2);
WebElement chechboxes1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
chechboxes1.click();
driver.quit();
    }
}
