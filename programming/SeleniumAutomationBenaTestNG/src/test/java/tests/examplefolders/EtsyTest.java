package tests.examplefolders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.SeleniumUtils;

public class EtsyTest {



    @Test
    public void EtsyTest(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com/");
    }
    @Test (groups= {"sanity","login"  })
    public void Etsytest2(){
        System.out.println("this is the second test of etsy");
        SeleniumUtils.waitForSec(5);
    }

    @Test

    public void EtsyTest3(){
        System.out.println("hey this is third test of etsy");
    }
}
