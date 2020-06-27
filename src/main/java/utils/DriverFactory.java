package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;

    public WebDriver getDriver(){
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/java/utils/drivers/chromedriver");
            driver = new ChromeDriver();

        }catch (Exception e){
            System.out.println("Enable to load browser "+ e);
        }finally {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }

        return driver;
    }
}
