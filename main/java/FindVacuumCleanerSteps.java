import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalMethods;
import java.util.List;



public class FindVacuumCleanerSteps {
    private static final String VACUUM_CLEANER = ".//*[@id='search-prepack']/div/div/div[3]/div/div[2]/div[13]/fieldset/div/label/div";
    private static final String FORM ="div.n-snippet-card2:nth-child(1) > div:nth-child(5)";
    private static final String DEFERRED = "html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div/a/i[1]";
    private static final String PROFILE = ".n-passport-suggest-popup-opener > a:nth-child(1) > span:nth-child(1)";
    private static final String DEFERRED_LIST = ".header2-user-menu__item_type_wishlist > a:nth-child(1)";
    private static final String ADDED_NAME = ".n-snippet-card2:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)";
    private static final String WISH_LIST = ".n-wishlist-list";

    public static void setCheckBox(WebDriverWait wait) {
        GlobalMethods.clickElemByXPath(wait, VACUUM_CLEANER);
    }

    public static String getAddedName(WebDriverWait wait) {
        return GlobalMethods.getTextOfField(wait, ADDED_NAME);
    }

    public static void addToDeferred(WebDriverWait wait) {
        GlobalMethods.clickElemByXPath(wait, DEFERRED);
    }

    public static void checkDeferredList(WebDriverWait wait) {
        GlobalMethods.clickElemBySelect(wait, PROFILE);
        GlobalMethods.clickElemBySelect(wait, DEFERRED_LIST);
    }
    public static List<WebElement> getDeferredList(WebDriverWait wait) {
        WebElement baseTable = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(WISH_LIST)));
        return baseTable.findElements(By.tagName("a"));

    }
    public static void moveToDeferred(WebDriver driver, WebDriverWait wait) {
        Actions builder = new Actions(driver);
        builder.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FORM))));
    }
}
