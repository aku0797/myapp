package tests;

import org.openqa.selenium.WebDriver;
import utilities.Driver;

public abstract class Page {
    protected WebDriver driver;
public Page ()

    public void printUrl() {
        System.out.println(Driver.getDriver().getCurrentUrl());

    }

    public void printTitle() {

        System.out.println(Driver.getDriver().getTitle());
    }
}
