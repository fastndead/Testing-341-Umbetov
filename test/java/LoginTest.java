import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WebDriverLoader;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginTest {


    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = WebDriverLoader.setDriver();
        wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Login test with correct data, than test checks that the user sing in.")
    @Test(groups = { "basic" })
    public void loginTest(){
        WebDriverLoader.loadPage(driver, PAGENAME);
        String login = LoginSteps.login(wait, driver);
        Assert.assertEquals(LoginSteps.getUserName(wait), login);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }
}
