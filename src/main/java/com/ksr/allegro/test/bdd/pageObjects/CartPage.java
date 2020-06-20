package com.ksr.allegro.test.bdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    protected CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sprawdza czy właściwy produkt został dodany do koszyka
     * @param nameOfItem nazwa oczekiwanego produktu
     * @return boolean: true lub false
     */
    public boolean verifyThatTheElementIsInTheCart(String nameOfItem) {
        try {
            driver.findElement(By.xpath("//a[contains(text(), '"+nameOfItem+"')]")).isEnabled();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    /**
     * Usuwa przedmiot z koszyka
     */
    public void removeItem(){
        driver.findElement(By.cssSelector("i[title = 'usuń przedmiot']")).click();
    }

    /**
     * Sprawdza, czy koszyk jest pusty
     * @return wartość true lub false
     */
    public boolean verifyIfCartIsEmpty(){
        try {
            driver.findElement(By.xpath("//span[contains(text(), 'Twój koszyk jest pusty')]")).isDisplayed();
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
