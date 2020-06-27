package com.ksr.allegro.test.bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.ksr.allegro.test.bdd.steps",
        monochrome = true,
        tags = {}
        )
public class MainRunner {
}
