package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends BasePage{
    protected ItemPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Zwraca nazwę produktu umieszczoną w tytule
     * @return nazwa produktu
     */
    public String getItemName() {
        By itemName = By.cssSelector("div h1");
        wait.until(driver1 -> driver.findElement(itemName).isDisplayed());
        return driver.findElement(itemName).getText();
    }

    /**
     * Dodaje produkt do koszyka
     */
    public void addToCart() {
        By addToCartButton = By.cssSelector("button#add-to-cart-button");
        wait.until(x -> x.findElement(addToCartButton).isDisplayed());
        driver.findElement(addToCartButton).click();
    }


    /**
     * Przechodzi do koszyka
     * @return Page object Koszyk
     */
    public CartPage goToCart() {
        By goToCartButton = By.cssSelector("a[data-analytics-click-label='goToCart']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCartButton));
        driver.findElement(goToCartButton).click();
        wait.until(driver1 -> driver1.findElement(By.name("allegro-cart")));

        return new CartPage(driver);
    }
}
