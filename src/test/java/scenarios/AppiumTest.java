package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void captureName() {
        LoginPage login = new LoginPage(driver).invalidLogin();

    }

    @Test
    public void showlogs() {
        LoginPage login = new LoginPage(driver).popWindow();

    }

}