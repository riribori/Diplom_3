package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ForgotPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement buttonEnterInForgotPassword;

    public ForgotPasswordPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }
}
