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
    public static WebDriver create() {
        return create(new MutableCapabilities());
    }

    public static WebDriver create(MutableCapabilities browserOptions) {
        String browser = System.getProperty("browser", "CHROME").toUpperCase();
       WebDriverName webDriverName = WebDriverName.valueOf(browser);
        switch (webDriverName) {
            case CHROME:
                //            WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().merge(browserOptions));
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "/Users/borisova/yandexdriver");
                return new ChromeDriver(new ChromeOptions().merge(browserOptions));
            default:
                //           WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().merge(browserOptions));
        }
    }
}