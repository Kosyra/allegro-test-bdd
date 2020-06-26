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
    MainPage mainPage = new MainPage(driver);
    ListingPage listingPage;
    ItemPage itemPage;
    CartPage cartPage;
    String nameOfItem;

    @Given("User navigates to the allegro website")
    public void user_navigates_to_the_allegro_website() {
        mainPage.goToMainPage();
    }

    @When("User searches for {string}")
    public void user_searches_for(String item) {
        listingPage = mainPage.searchForItems(item);
    }

    @When("Set minimum price to {int} PLN")
    public void set_minimum_price_to_PLN(Integer price) {
        listingPage.setMinimumPrice(price);
    }

    @When("check used checkbox")
    public void check_used_checkbox() {
        listingPage.selectStatusInUsed();
    }

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
