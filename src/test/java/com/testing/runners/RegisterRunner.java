package com.testing.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/register.feature",
    glue = {"com.testing.stepdefs"},
    plugin = {"pretty", "html:target/cucumber-register-report.html"},
    monochrome = true
)
public class RegisterRunner {
}

