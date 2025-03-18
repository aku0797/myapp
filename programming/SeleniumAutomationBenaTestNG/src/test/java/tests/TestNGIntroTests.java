package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.Driver;

public class TestNGIntroTests  extends Page{


    public TestNGIntroTests(WebDriver driver) {
        super(driver);
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @Override
    public void search(String... parameters) {

        String username= parameters[0];


    }

    @BeforeTest
    public static void beforeTestMethod(){
        System.out.println("this is before test method");
    }
@BeforeMethod
    public void beforemethod(){

        System.out.println("this is before method");
    }
@AfterTest
public static void afterTestMethod(){
    System.out.println("this is after test method");
}

@BeforeClass
    public void beforeClass(){
    System.out.println("this is before class");
}

@Test
    public void test1(){
    System.out.println("i am test1 ");
    Assert.assertTrue(5>2);
}
@Test
    public void test2(){
    Assert.assertFalse(5<2);
    System.out.println("i am test2 ");
}@Test
    public void test3(){
    Assert.assertFalse(5<2);
    System.out.println("i am test3");
}@Test
    public void test4(){
    Assert.assertFalse(5<2);
    System.out.println("i am test4 ");
}


}
