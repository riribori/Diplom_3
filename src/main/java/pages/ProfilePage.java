package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProfilePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement buttonExit;

    @FindBy(xpath = "//p[text()='Конструктор']")
    private WebElement buttonConstructor;

    @FindBy(xpath = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private WebElement buttonLogo;

    public ProfilePage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

}
