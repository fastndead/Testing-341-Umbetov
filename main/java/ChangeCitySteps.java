import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalMethods;

public class ChangeCitySteps {

    private static final String ANOTHER_CITY_BUTTON = ".button2_theme_normal";
    private static final String CITY_BUTTON = "span.link:nth-child(1)";
    private static final String CITY_INPUT = "div.input > span:nth-child(1) > input:nth-child(2)";
    private static final String BUTTON_AGREE = ".suggestick-list";
    private static final String BUTTON_CHANGE = ".button";
    private static final String CHANGED_CITY = "span.link:nth-child(1) > span:nth-child(2)";


    public static void changeCity(WebDriverWait wait) {

        WebElement anotherCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ANOTHER_CITY_BUTTON)));

        WebElement City = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CITY_BUTTON)));
        if (anotherCity != null)
            anotherCity.click();
        else
            City.click();
    }


    public static void setCity(WebDriverWait wait, String tempCity) {
        GlobalMethods.sendKeysBySelect(wait, CITY_INPUT, tempCity);

        GlobalMethods.clickElemBySelect(wait, BUTTON_AGREE);
        GlobalMethods.clickElemBySelect(wait, BUTTON_CHANGE);

    }

    public static String getChangedCityName(WebDriverWait wait) {
        return GlobalMethods.getTextOfField(wait, CHANGED_CITY);
    }

    public static void getInitialCityName(WebDriverWait wait, String initial_City) {
        GlobalMethods.clickElemBySelect(wait, initial_City);
    }

    public static String getRealCityName(WebDriverWait wait, String real_City) {
        return GlobalMethods.getTextOfField(wait, real_City);
    }
}




