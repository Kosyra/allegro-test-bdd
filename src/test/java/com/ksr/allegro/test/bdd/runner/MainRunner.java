package com.ksr.allegro.test.bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features.cart",
        glue = "com.ksr.allegro.test.bdd.steps",
        monochrome = true,
        tags = {}
//        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
        )
public class MainRunner {
}
