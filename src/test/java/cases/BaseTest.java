package cases;

import general.Steps;
import general.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected static Steps step;

    @Before
    public void setUp()
    {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        step = new Steps(driver);

    }
    @After
    public void teardown() {
        driver.quit();
    }
}

