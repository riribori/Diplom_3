package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement buttonEnterInMain;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement buttonPersonalAccountInMain;

    @FindBy(xpath = "//span[text()='Булки']")
    private WebElement tabBun;

    @FindBy(xpath = "//span[text()='Соусы']")
    private WebElement tabSauce;

    @FindBy(xpath = "//span[text()='Начинки']")
    private WebElement tabIngredient;

    public MainPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getParent  (WebElement child) {
        return  (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].parentNode;", child);
    }
}
