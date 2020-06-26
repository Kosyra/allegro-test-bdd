package com.ksr.allegro.test.bdd.steps.cart;

import com.ksr.allegro.test.bdd.pageObjects.CartPage;
import com.ksr.allegro.test.bdd.pageObjects.ItemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DriverFactory;

public class RemoveItemFromTheCartSteps extends DriverFactory {
    ItemPage itemPage;
    CartPage cartPage;

    @And("remove item from the cart")
    public void removeItemFromTheCart() {
        itemPage = new ItemPage(driver);
        cartPage = itemPage.goToCart();
        cartPage.removeItem();
    }

    @Then("the cart is empty")
    public void theCartIsEmpty() {
        Assert.assertTrue("Nie została wyświetlona informacja, że koszyk jest pusty", cartPage.verifyIfCartIsEmpty());
    }
}
