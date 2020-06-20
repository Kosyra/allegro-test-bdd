package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver driver;
    public WebDriver getDriver(){
        //get ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/ksr/Downloads/chromedriver");
        driver = new ChromeDriver();

        return driver;
    }
}
