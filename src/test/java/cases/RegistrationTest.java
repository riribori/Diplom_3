package cases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;



public class RegistrationTest extends BaseTest {

        @Test
        public void testRegistration() {

            driver.get("https://stellarburgers.nomoreparties.site/register");
            step.setName(RandomStringUtils.randomAlphabetic(10));
            step.setEmail(RandomStringUtils.randomAlphabetic(10) + "@mail.ru");
            step.setPassword(RandomStringUtils.randomAlphabetic(6));
            step.clickRegistration();
            Assert.assertTrue("Не появилась форма логина",step.showLoginPage());
        }

    @Test
    public void testRegistrationWithErrorPassword() {

        driver.get("https://stellarburgers.nomoreparties.site/register");
        step.setName(RandomStringUtils.randomAlphabetic(10));
        step.setEmail(RandomStringUtils.randomAlphabetic(10) + "@mail.ru");
        step.setPassword(RandomStringUtils.randomAlphabetic(5));
        step.clickRegistration();
        Assert.assertTrue("Не появилась ошибка при вводе пароля меньше 6 символов",step.showPasswordError());
    }
    }
