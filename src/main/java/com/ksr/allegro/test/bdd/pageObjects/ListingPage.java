package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListingPage extends BasePage {
    public ListingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Zaznacza checkbox "używane"
     */
    public void selectStatusInUsed() {
        By usedItemsCheckbox = By.xpath("//span[contains(text(), 'używane')]");
        wait.until(driver1 -> driver1.findElement(usedItemsCheckbox).isDisplayed());
        actions.moveToElement(driver.findElement(usedItemsCheckbox)).click().perform();
    }

    /**
     * Wprowadza cenę minimalną
     * @param price kwota w PLN za przedmiot
     */
    public void setMinimumPrice(int price) {
        By priceField = By.cssSelector("input#price_from");
        actions.moveToElement(driver.findElement(priceField)).perform();
        driver.findElement(priceField).sendKeys(String.valueOf(price));
    }

    /**
     * Przechodzi na stronę przedmiotu
     * @return Page object przedmiotu
     */
    public ItemPage goToItemPage() throws InterruptedException {
        //TODO dodać czekanie na element po ustaleniu na jaki element poczekać, żeby upewnić się, że sekcja została załadowana
        Thread.sleep(2000);
        WebElement offersGrid = driver.findElements(By.cssSelector("section article")).get(2);
        actions.moveToElement(offersGrid);
        offersGrid.click();

        return new ItemPage(driver);
    }
}
