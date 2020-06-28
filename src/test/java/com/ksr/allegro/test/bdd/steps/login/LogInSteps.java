package com.ksr.allegro.test.bdd.steps.login;

import com.ksr.allegro.test.bdd.pageObjects.MainPage;
import io.cucumber.java.en.Given;
import utils.DriverFactory;

public class LogInSteps extends DriverFactory {
    private final MainPage mainPage = new MainPage(driver);

    @Given("User navigates to the allegro website")
    public void user_navigates_to_the_allegro_website() {
        mainPage.goToMainPage();
    }
}
