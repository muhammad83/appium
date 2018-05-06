package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePage {
    By chromeButton = By.id("buttonStartWebview");
    By nameInputField = By.id("name_input");
    By carPopUp = By.id("content");
    By merc = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
    By sendButton = By.id("Send me your name!");
    By popResult = By.id("tableRowWebview");

    By nameCheck = By.xpath("//android.view.View[@content-desc=\"Your name is:\"]");
    By carCheck = By.xpath("//android.view.View[@content-desc=\"Your name is:\"]");


    By popUpWindow = By.id("showPopupWindowButton");
    By popUpWindowShow = By.id("showPopupWindowButton");

    By exceptionButton = By.id("exceptionTestButton");

    By crashPopUp = By.id("alertTitle");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage invalidLogin() {
        waitForVisibilityOf(chromeButton, 60);
        driver.findElement(chromeButton).click();

        waitForVisibilityOf(nameInputField, 60);

        driver.findElement(nameInputField).clear();
        driver.findElement(nameInputField).sendKeys("Muhammad");
        driver.findElement(By.id("Volvo")).click();

        waitForVisibilityOf(carPopUp, 60);

        driver.findElement(merc).click();
        driver.findElement(sendButton).click();

        waitForVisibilityOf(popResult, 60);

        assertEquals(driver.findElement(nameCheck).getText(),"Muhammad");
        assertEquals(driver.findElement(carCheck).getText(),"mercedes");

        return new LoginPage(driver);
    }


    public LoginPage popWindow() {
        waitForVisibilityOf(popUpWindow, 60);
        driver.findElement(popUpWindow).click();

        waitForVisibilityOf(popUpWindowShow, 60);

        driver.findElement(popUpWindow).click();

        waitForVisibilityOf(exceptionButton, 60);

        driver.findElement(exceptionButton).click();

        waitForVisibilityOf(crashPopUp, 60);

        assertEquals(driver.findElement(crashPopUp).getText(),"selendroid-test-app has stopped");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Assert.assertTrue(scrFile.exists());

        return new LoginPage(driver);
    }
}