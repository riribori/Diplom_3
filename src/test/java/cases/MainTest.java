package cases;

import general.CreateUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest extends BaseTest {

    static CreateUser createUser;
    @Before
    public void createUser () {
        createUser = new CreateUser(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10) + "@mail.ru", RandomStringUtils.randomAlphabetic(6));
        step.createNewUser(createUser);
    }

    @Test
    public void testMoveToPersonalAccountFromMain() {

        driver.get("https://stellarburgers.nomoreparties.site/login");
        step.loginUser(createUser);
        step.clichPersonalAccountOnMain();
        Assert.assertTrue("Не открылась страница с профилем",step.showPersonalAccountPage());

    }
}
