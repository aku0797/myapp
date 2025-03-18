//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    public static WebDriver driver;

    public Driver() {
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            switch (Config.getProp("browser")) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(new String[]{"disable-popup-blocking"});
                    options.addArguments(new String[]{"start-maximized"});
                    options.addArguments(new String[]{"incognito"});
                    Map<String, Object> prefs = new HashMap();
                    prefs.put("profile.default_content_setting_values.geolocation", 2);
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
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60L));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60L));
            return driver;
        }
    }
}
