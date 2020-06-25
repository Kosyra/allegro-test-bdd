package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Adres url głównej strony Allegro.pl
     */
    private static final String urlMain = "https://allegro.pl";

    /**
     * Pole tekstowe "Czego szukasz?"
     */
    private @FindBy(name = "string")
    WebElement searchField;

    /**
     * Przycisk "Szukaj"
     */
    private @FindBy(xpath = "//button[@data-role = 'search-button']")
    WebElement searchButton;

    /**
     * Okno z informacją o cookies
     */
    private @FindBy(id = "dialog-content")
    WebElement cookiesWindow;

    /**
     * Przycisk "Przejdź dalej" w oknie akceptacji cookies
     */
    private @FindBy(css = "button[data-role = 'accept-consent']")
    WebElement moveForwardCookiesButton;

    /**
     * Przechodzi na stronę główną allegro
     */
    public void goToMainPage(){
        driver.get(urlMain);
        ClosePopUpWindow();
    }

    /**
     * Wyszukuje dany przedmiot
     * @param  item nazwa szukanego przedmiotu
     */
    public ListingPage searchForItems(String item) {
        searchField.sendKeys(item);
        PressSearchButton();

        return new ListingPage(driver);
    }


    /**
     * Klika w przycisk "Szukaj"
     */
    private void PressSearchButton() {
        searchButton.click();
    }

    /**
     * Zamyka okno o akceptacji śledzenia
     */
    private void ClosePopUpWindow() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-role = 'accept-consent']")));
            moveForwardCookiesButton.click();
        }catch (Exception ignored){}
    }
}