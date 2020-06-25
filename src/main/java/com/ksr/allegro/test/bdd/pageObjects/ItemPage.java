package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BasePage{
    protected ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Przycisk "Dodaj do koszyka"
     */
    @FindBy(css = "button#add-to-cart-button")
    WebElement addToCartButton;

    /**
     * Przycisk "Przejdź do koszyka"
     */
    @FindBy(css = "a[data-analytics-click-label='goToCart']")
    WebElement goToCartButton;

    /**
     * Nagłówek z nazwą przedmiotu
     */
    @FindBy(css = "div h1")
    WebElement itemName;

    /**
     * Zwraca nazwę produktu umieszczoną w tytule
     * @return nazwa produktu
     */
    public String getItemName() {
        wait.until(x -> itemName.isDisplayed());
        return itemName.getText();
    }

    /**
     * Dodaje produkt do koszyka
     */
    public void addToCart() {
        wait.until(x -> addToCartButton.isDisplayed());
        actions.moveToElement(addToCartButton);
        addToCartButton.click();
    }


    /**
     * Przechodzi do koszyka
     * @return Page object Koszyk
     */
    public CartPage goToCart() {
        wait.until(x -> goToCartButton.isDisplayed());
        actions.moveToElement(goToCartButton);
        goToCartButton.click();
        wait.until(x -> x.findElement(By.name("allegro-cart")));

        return new CartPage(driver);
    }
}
