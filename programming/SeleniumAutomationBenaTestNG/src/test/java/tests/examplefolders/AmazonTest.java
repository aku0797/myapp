package tests.examplefolders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AmazonTest {


    @Test (groups= {"sanity"})
    public void AmazonTest(){
        WebDriver driver=new ChromeDriver();
       driver.get("https://www.amazon.com/");
    }

    @Test (groups= {"login","sanity"})
    public void Amazontest2(){
        System.out.println("this is the second test");
        SeleniumUtils.waitForSec(5);
    }

    @Test

    public void AmazonTest3(){
        System.out.println("hey this is third test");
    }
}
