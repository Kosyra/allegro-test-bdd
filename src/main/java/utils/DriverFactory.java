package utils;

import com.ksr.allegro.test.bdd.pageObjects.CartPage;
import com.ksr.allegro.test.bdd.pageObjects.ItemPage;
import com.ksr.allegro.test.bdd.pageObjects.ListingPage;
import com.ksr.allegro.test.bdd.pageObjects.MainPage;
import io.netty.handler.codec.http2.Http2ConnectionPrefaceAndSettingsFrameWrittenEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;

    public static MainPage mainPage;
    public static CartPage cartPage;
    public static ItemPage itemPage;
    public static ListingPage listingPage;

    public WebDriver getDriver(){
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/ksr/Downloads/chromedriver");
            driver = new ChromeDriver();

        }catch (Exception e){
            System.out.println("Enable to load browser "+ e);
        }finally {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }

        return driver;
    }
}
