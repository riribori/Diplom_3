package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement buttonExit;

    @FindBy(xpath = "//p[text()='Конструктор']")
    private WebElement buttonConstructor;

    @FindBy(xpath = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private WebElement buttonLogo;

}
