import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.WebDriverLoader;

public class FindMouseWithParamsTest {

    private static FindMouseWithParamsSteps findMouseWithParamsSteps;
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

    @BeforeMethod
    public void initialize() {
        findMouseWithParamsSteps = new FindMouseWithParamsSteps();
    }

    @DataProvider(name = "testWithParams")
    public static Object[][] valueMinMax() {
        return new Object[][]{{800, 1000}, {200, 1000}, {2000, 5000}};
    }

    @Test(dataProvider = "testWithParams")
    public void testFindMouseWithParams(int minPriceValue, int maxPriceValue) {
        WebDriverLoader.loadPage(driver, PAGENAME);
        Assert.assertTrue(findMouseWithParamsSteps.findMouse(wait, minPriceValue, maxPriceValue ));
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }
}
