package cases;

import general.CreateUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnterTest extends BaseTest {

    static CreateUser createUser;

    @Before
    public void createUser () {
        createUser = new CreateUser(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10) + "@mail.ru", RandomStringUtils.randomAlphabetic(6));
        step.createNewUser(createUser);
    }

    @Test
    public void testEnterFromRegistrationPage()
    {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        step.clickEnterOnRegistrationPage();
        Assert.assertTrue("Не появилась форма логина",step.showLoginPage());
        step.setEmailLogin(createUser.getEmail());
        step.setPasswordLogin(createUser.getPassword());
        step.clickEnterOnLoginPage();
        Assert.assertTrue("Не загрузилась страница с конструктором после логина",step.showTabBun());
    }
}
