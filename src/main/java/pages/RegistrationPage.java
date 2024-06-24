package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class RegistrationPage {
    
    private WebDriver driver;

    @FindBy(xpath = "//label[text()='Имя']/following-sibling::input")
    private WebElement inputName;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement inputMail;

    @FindBy(xpath = "//label[text()='Пароль']/following-sibling::input")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement buttonRegistration;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement buttonEnterInRegistration;

    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    private WebElement messageErrorPassword;


    public RegistrationPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

}






