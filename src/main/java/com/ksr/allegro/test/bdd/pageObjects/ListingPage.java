package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingPage extends BasePage {
    public ListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Checkbox "używane"
     */
    @FindBy(xpath = "//span[contains(text(), 'używane')]")
    WebElement usedCheckbox;

    /**
     * Pole tekstowe "cena minimalna"
     */
    @FindBy(css = "input#price_from")
    WebElement minimumPriceField;

    /**
     * Grid z przedmiotami
     */
    @FindBy(css = "section article")
    List<WebElement> itemsGrid;

    /**
     * Zaznacza checkbox "używane"
     */
    public void selectStatusInUsed() {
        wait.until(driver1 -> usedCheckbox.isDisplayed());
        actions.moveToElement(usedCheckbox).click().perform();
    }

    /**
     * Wprowadza cenę minimalną
     * @param price kwota w PLN za przedmiot
     */
    public void setMinimumPrice(int price) {
        actions.moveToElement(minimumPriceField).perform();
        minimumPriceField.sendKeys(String.valueOf(price));
        final boolean displayed = wait.until(driver -> driver
                .findElements(By.cssSelector("div")))
                .stream()
                .anyMatch(driver -> driver
                        .findElement(By.xpath("//span[contains(text(), 'cena')]")).isDisplayed());
    }

    /**
     * Przechodzi na stronę przedmiotu
     * @return Page object przedmiotu
     */
    public ItemPage goToAnyItemPage() {
        WebElement item = itemsGrid.get(1);
        actions.moveToElement(item);
        item.click();

        return new ItemPage(driver);
    }
}
