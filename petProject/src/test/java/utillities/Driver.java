package utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utillities.Config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        String browser = Config.getProp("browser");

        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("start-maximized");
                options.addArguments("incognito");

                //use preferences to disable geolocation permission prompt
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.geolocation",2);//2 is a block
                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;

//
//    static WebDriver driver;
//    static final String browserType= Config.getProp ("browser");
//    public static  WebDriver getDriver(){
//        if ( driver==null){
//            switch (browserType) {
//                case "firefox" -> driver = new FirefoxDriver();
//                case "edge" -> driver = new EdgeDriver();
//                default -> driver = new ChromeDriver();
//            }
//            driver.manage().window().maximize();
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//            return driver;
//
//            }
//        return driver;
//
//        }
//    public static void quit (){
//        if(driver!= null){
//            driver.quit();
//            driver=null;
//        }

    }
}
