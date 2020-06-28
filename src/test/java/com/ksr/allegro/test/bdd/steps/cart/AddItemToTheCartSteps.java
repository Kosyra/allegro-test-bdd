package com.ksr.allegro.test.bdd.steps.cart;

import com.ksr.allegro.test.bdd.pageObjects.CartPage;
import com.ksr.allegro.test.bdd.pageObjects.ItemPage;
import com.ksr.allegro.test.bdd.pageObjects.ListingPage;
import com.ksr.allegro.test.bdd.pageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DriverFactory;

public class AddItemToTheCartSteps extends DriverFactory {
    ListingPage listingPage = new ListingPage(driver);
    ItemPage itemPage;
    CartPage cartPage;
    String nameOfItem;

    @And("will go to the eny item page")
    public void willGoToTheEnyItemPage() {
        itemPage = listingPage.goToAnyItemPage();
        nameOfItem = itemPage.getItemName();
    }

    @When("will add item to the cart")
    public void will_add_item_to_the_cart() {
        itemPage.addToCart();
    }

    @Then("the item is added to the cart")
    public void the_item_is_added_to_the_cart() {
        cartPage = itemPage.goToCart();
        Assert.assertTrue("W koszyku nie znajduje się oczekiwany produkt",cartPage.verifyThatTheElementIsInTheCart(nameOfItem));}
}
