package com.ksr.allegro.test.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class MasterHooks extends DriverFactory {

    @Before
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
