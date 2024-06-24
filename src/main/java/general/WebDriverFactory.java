package general;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static WebDriver create(WebDriverName webDriverName) {
        return create(webDriverName, new MutableCapabilities());
    }

    public static WebDriver create(WebDriverName webDriverName, MutableCapabilities browserOptions) {
        switch (webDriverName) {
            case CHROME:
                //            WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().merge(browserOptions));
            case FIREFOX:
                //           WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions().merge(browserOptions));
            default:
                //           WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().merge(browserOptions));
        }
    }
}