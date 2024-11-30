package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {
@BeforeMethod
    public void beforemethod(){

        System.out.println("this is before method");
    }
@BeforeClass
    public void beforeClass(){
    System.out.println("this is before class");
}

@Test
    public void test1(){
    System.out.println("i am test1 ");
}
@Test
    public void test2(){
    System.out.println("i am test2 ");
}


}
