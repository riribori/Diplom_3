package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement buttonEnterInForgotPassword;
}
