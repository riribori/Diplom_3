package general;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;
import static io.restassured.RestAssured.given;

public class Steps {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProfilePage profilePage;
    private ForgotPasswordPage forgotPassportPage;

    public Steps (WebDriver webDriver) {
        this.driver = webDriver;
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        forgotPassportPage = new ForgotPasswordPage(driver);
    }

    @Step("Вводим имя")
            public void setName (String name) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(registrationPage.getInputName()));
        registrationPage.getInputName().sendKeys(name);
    }

    @Step("Вводим почту")
    public void setEmail (String email){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(registrationPage.getInputMail()));
        registrationPage.getInputMail().sendKeys(email);
    }

    @Step("Вводим пароль")
    public void setPassword (String password){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(registrationPage.getInputPassword()));
        registrationPage.getInputPassword().sendKeys(password);
    }
    @Step("Кликаем на кнопку регистрации")
    public void clickRegistration () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(registrationPage.getButtonRegistration()));
        registrationPage.getButtonRegistration().click();
    }
    @Step("Проверяем отображение ошибки пароля")
    public boolean showPasswordError() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(registrationPage.getMessageErrorPassword()));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Step("Кликаем на кнопку войти")
    public void clickEnterOnRegistrationPage () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(registrationPage.getButtonEnterInRegistration()));
        registrationPage.getButtonEnterInRegistration().click();
    }

    @Step("Кликаем на кнопку войти на форме восстановления пароля")
    public void clickEnterOnForgotPassportPage () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(forgotPassportPage.getButtonEnterInForgotPassword()));
        forgotPassportPage.getButtonEnterInForgotPassword().click();
    }

    @Step("Проверяем отображениы страницу логина")
    public boolean showLoginPage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(loginPage.getButtonEnterInLogin()));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Step("Проверяем отображениы страницу с личным кабинетом")
    public boolean showPersonalAccountPage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(profilePage.getButtonExit()));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Step("Вводим почту на форме логина")
    public void setEmailLogin (String login) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(loginPage.getInputMail()));
        loginPage.getInputMail().sendKeys(login);
    }

    @Step("Вводим почту на форме логина")
    public void setPasswordLogin (String password) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(loginPage.getInputPassword()));
        loginPage.getInputPassword().sendKeys(password);
    }

    @Step("Кликаем на кнопку войти на странице логина")
    public void clickEnterOnLoginPage () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(loginPage.getButtonEnterInLogin()));
        loginPage.getButtonEnterInLogin().click();
    }

    @Step("Отображаем таб с булками")
    public boolean showTabBun() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(mainPage.getTabBun()));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Step("Кликаем на кнопку Личный кабинет на главной")
    public void clichPersonalAccountOnMain() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(mainPage.getButtonPersonalAccountInMain()));
        mainPage.getButtonPersonalAccountInMain().click();
    }

    @Step("Кликаем на кнопку Войти на главной")
    public void clickEnterPageOnMain () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(mainPage.getButtonEnterInMain()));
        mainPage.getButtonPersonalAccountInMain().click();
    }

    @Step ("Логин пользователя")
    public void loginUser(CreateUser createUser){
        setEmailLogin(createUser.getEmail());
        setPasswordLogin(createUser.getPassword());
        clickEnterOnLoginPage();
        Assert.assertTrue("Не загрузилась страница с конструктором после логина",showTabBun());
    }

    @Step("Create User")
    public Response createNewUser (CreateUser createUser){
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(createUser)
                        .when()
                        .post("api/auth/register");
        return response;
    }
}
