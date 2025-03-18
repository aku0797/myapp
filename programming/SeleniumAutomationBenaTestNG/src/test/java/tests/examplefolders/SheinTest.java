package tests.examplefolders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.SeleniumUtils;

public class SheinTest {


    @Test
    public void sheinTest(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.shein.com/");


    }

    @Test (groups= {"sanity"})
    public void Shdeintest2(){
        System.out.println("this is the second test of shein");
        SeleniumUtils.waitForSec(5);
    }

    @Test(groups= {"login"})

    public void SheinTest3(){
        System.out.println("hey this is third test of shein");
    }



    @BeforeSuite
    public static void beforesuite(){
        System.out.println("this is before suite ");



    }
    @AfterSuite
    public static void aftersuite(){
        System.out.println("this is after suite ");



    }
}
