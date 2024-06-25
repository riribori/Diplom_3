package cases;

import general.CreateUser;
import general.DeleteUser;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;

public class MainTest extends BaseTest {

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
    public void testMoveToPersonalAccountFromMain() {

        driver.get("https://stellarburgers.nomoreparties.site/login");
        step.loginUser(createUser);
        step.clichPersonalAccountOnMain();
        Assert.assertTrue("Не открылась страница с профилем",step.showPersonalAccountPage());
    }
    @Test
    public void testSwitch(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
        step.loginUser(createUser);
        step.clickSouseTab();
        step.clickIngredientsTab();
        step.clickBunTab();
    }
    @After
    public void deleteUser() {
        step.deleteUser(new DeleteUser(email, name), token).then().statusCode(202);
}
}
