import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindMouseSteps {

    private static final String REAL_PRICE_MIN = "div.n-snippet-cell2:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)";
    private static final String REAL_PRICE_MAX = "div.n-snippet-cell2:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)";
    private static final String FORWARD = "html.i-ua_js_yes.i-ua_css_standard.i-ua_os-family_windows.i-ua_browser-engine_gecko.i-ua_browser-name_firefox.i-ua_browser-version_43-0.i-ua_placeholder_yes.i-ua_svg_yes.i-ua_inlinesvg_yes.i-ua_geolocation_no.pointerfocus body.b-page.b-page__body.b-page_theme_normal.n-layout_name_list.n-layout.i-global.i-anchor-scroller.i-font-loader.i-font_face_ys-text.b-zone.b-spy-init.i-bem.b-page_js_inited.i-global_js_inited.n-layout_js_inited.i-anchor-scroller_js_inited.i-font-loader_js_inited.b-spy-init_js_inited.b-zone_js_inited.fonts-loaded div.main div.layout.layout_type_maya div.layout.layout_type_search.i-bem div.layout__col.i-bem.layout__col_search-results_normal div.n-filter-applied-results.metrika.b-zone.i-bem.n-filter-applied-results_js_inited.b-zone_js_inited div.n-filter-applied-results__content.preloadable.i-bem.preloadable_js_inited div.n-pager.i-bem.n-pager_js_inited a.button.button_size_s.button_theme_pseudo.n-pager__button-next.i-bem.button_js_inited";
    public static Pair<String, String> findMaxAndMin(WebDriverWait wait){


        WebElement MinPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REAL_PRICE_MIN)));
        String smin = MinPrice.getText().replaceAll("\u20BD","").replaceAll(" ","");


        WebElement MaxPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REAL_PRICE_MAX)));
        String smax = MaxPrice.getText().replaceAll("\u20BD","").replaceAll(" ","");

        return  new Pair<String, String>(smin, smax);
    }

    public static List<String> findListOfMouses(WebDriverWait wait){
        List<String> result = new ArrayList<>();
       // boolean exst = false;
        //do {
            List<WebElement> mouses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("n-snippet-list"))).findElements(By.xpath("//div[@class = 'price']"));
            for (WebElement e : mouses) {
                result.add(e.getText().replaceAll("\u20BD", "").replaceAll(" ", ""));
            }
           // try {
              // WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(FORWARD)));
             //   btn.click();
              //  exst = true;
           // } catch (Exception e) {
               // exst = false;
          //  }
        //}while (exst);
        //WebElement MinPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REAL_PRICE_MIN)));
        //String smin = MinPrice


        //WebElement MaxPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REAL_PRICE_MAX)));
        //String smax = MaxPrice.getText().replaceAll("\u20BD","").replaceAll(" ","");

        return  result;
    }

}
