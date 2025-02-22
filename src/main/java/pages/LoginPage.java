package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement buttonEnterInLogin;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement inputMail;

    @FindBy(xpath = "//label[text()='Пароль']/following-sibling::input")
    private WebElement inputPassword;

    public LoginPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }
}
