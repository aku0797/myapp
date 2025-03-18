package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.SeleniumUtils;

public abstract class Page {


    protected WebDriver driver;


    public void navigateTo (String url){
        driver.get (url);
    }
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void printUrl() {
        System.out.println(driver.getCurrentUrl());

    }

    public void printTitle() {

        System.out.println(driver.getTitle());
    }

    public void logout(){

        WebElement profile = driver.findElement(By.xpath("//i[@class='oxd-icon bi caret-down-fill oxd-userdropdown-icon']"));
        WebElement logout= driver.findElement(By.linkText("Logout"));
        SeleniumUtils.click(driver, profile);
        logout.click();
    }

    public abstract void search (String ... parameters);

}
