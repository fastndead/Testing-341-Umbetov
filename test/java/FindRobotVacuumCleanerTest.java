import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalMethods;
import utils.WebDriverLoader;

public class FindRobotVacuumCleanerTest {

    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static final String QUERY_PRODUCT = "Робот пылесос";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = WebDriverLoader.setDriver();
        wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Login, add to the basket.")
    @Test(groups = {"Adding_to_basket"}, dependsOnMethods= "LoginTest.loginTest")
    public void addToBasket() {
        driver = WebDriverLoader.setDriver();
        wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);

        WebDriverLoader.loadPage(driver, PAGENAME);
        String login = LoginSteps.login(wait, driver);

        Assert.assertEquals(LoginSteps.getUserName(wait), login);
        GlobalMethods.searchField(wait, QUERY_PRODUCT);
        FindVacuumCleanerSteps.setCheckBox(wait);
        String addedName = FindVacuumCleanerSteps.getAddedName(wait);
        FindVacuumCleanerSteps.moveToDeferred(driver, wait);
        FindVacuumCleanerSteps.addToDeferred(wait);
        FindVacuumCleanerSteps.checkDeferredList(wait);
        boolean res = false;
        for (WebElement w: FindVacuumCleanerSteps.getDeferredList(wait)) {
            if(w.getText().equals(addedName))
                res = true;

        }
        Assert.assertTrue(res);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }


}
