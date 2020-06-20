package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Przechodzi na stronę główną allegro
     */
    public void goToMainPage(){
        driver.get("https://allegro.pl");
        ClosePopUpWindow();
    }

    /**
     * Wyszukuje dany przedmiot
     * @param  item nazwa szukanego przedmiotu
     */
    public ListingPage searchForItems(String item) {
        driver.findElement(By.name("string")).sendKeys(item);
        PressSearchButton();

        return new ListingPage(driver);
    }


    /**
     * Klika w przycisk "Szukaj"
     */
    private void PressSearchButton() {
        driver.findElement(By.xpath("//button[@data-role = 'search-button']")).click();
    }

    /**
     * Zamyka okno o akceptacji śledzenia
     */
    private void ClosePopUpWindow() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_4f735_RGj-r")));
            driver.findElement(By.xpath("//button[contains(text(),'przejdź dalej')]")).click();
        }catch (Exception ignored){}
    }
}