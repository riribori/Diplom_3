package cases;

import general.CreateUser;
import general.DeleteUser;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnterTest extends BaseTest {

    static CreateUser createUser;
    private static String token;
    private static String email;
    private static String name;
    @Before
    public void createUser () {
        createUser = new CreateUser(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10) + "@mail.ru", RandomStringUtils.randomAlphabetic(6));
        Response response = step.createNewUser(createUser);
        email = createUser.getEmail();
        name = createUser.getName();
        token = response.jsonPath().getString("accessToken");
    }

    @Test
    public void testEnterFromRegistrationPage()
    {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        step.clickEnterOnRegistrationPage();
        Assert.assertTrue("Не появилась форма логина",step.showLoginPage());
        step.loginUser(createUser);
    }

    @Test
    public void testEnterFromMainPage()
    {
        driver.get("https://stellarburgers.nomoreparties.site");
        step.clickEnterPageOnMain();
        Assert.assertTrue("Не появилась форма логина",step.showLoginPage());
        step.loginUser(createUser);
    }

    @Test
    public void testEnterByPersonalAccountInMain() {

        driver.get("https://stellarburgers.nomoreparties.site");
        step.clichPersonalAccountOnMain();
        Assert.assertTrue("Не появилась форма логина",step.showLoginPage());
        step.loginUser(createUser);
    }

    @Test
    public void testEnterFromForgotPasswordPage(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        step.clickEnterOnForgotPassportPage();
        Assert.assertTrue("Не появилась форма логина",step.showLoginPage());
        step.loginUser(createUser);
    }
    @After
    public void deleteUser() {
        step.deleteUser(new DeleteUser(email, name), token).then().statusCode(202);
    }
}
