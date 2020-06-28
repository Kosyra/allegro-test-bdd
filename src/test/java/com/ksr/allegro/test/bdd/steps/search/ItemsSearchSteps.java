package com.ksr.allegro.test.bdd.steps.search;

import com.ksr.allegro.test.bdd.pageObjects.ListingPage;
import com.ksr.allegro.test.bdd.pageObjects.MainPage;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class ItemsSearchSteps extends DriverFactory {
    private final MainPage mainPage = new MainPage(driver);
    private ListingPage listingPage;

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
}
