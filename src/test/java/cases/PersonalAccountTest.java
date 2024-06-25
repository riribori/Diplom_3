package cases;

import general.CreateUser;
import general.DeleteUser;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PersonalAccountTest extends BaseTest {

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
    public void testMoveToMainPageByLogo() {

        driver.get("https://stellarburgers.nomoreparties.site/login");
        step.loginUser(createUser);
        step.clichPersonalAccountOnMain();
        Assert.assertTrue("Не открылась страница с профилем",step.showPersonalAccountPage());
        step.clickLogoOnPersonalAccountPage();
        Assert.assertTrue("Не открылась страница с конструктором",step.showTabBun());
    }

    @Test
    public void testMoveToMainPageByConstructor() {

        driver.get("https://stellarburgers.nomoreparties.site/login");
        step.loginUser(createUser);
        step.clichPersonalAccountOnMain();
        Assert.assertTrue("Не открылась страница с профилем",step.showPersonalAccountPage());
        step.clickConstructorOnPersonalAccountPage();
        Assert.assertTrue("Не открылась страница с конструктором",step.showTabBun());
    }

    @Test
    public void testExit(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
        step.loginUser(createUser);
        step.clichPersonalAccountOnMain();
        Assert.assertTrue("Не открылась страница с профилем",step.showPersonalAccountPage());
        step.clickExitOnPersonalAccountPage();
        Assert.assertTrue("Не открылась страница с входом",step.showLoginPage());
    }

    @After
    public void deleteUser() {
        step.deleteUser(new DeleteUser(email, name), token).then().statusCode(202);
    }
}
