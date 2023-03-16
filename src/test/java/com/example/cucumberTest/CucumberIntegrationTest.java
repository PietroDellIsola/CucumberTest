package com.example.cucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = { "pretty" })
//plugin = { "pretty" } utilizzato per stampare in console i messaggi degli scenari di test di cucumber
public class CucumberIntegrationTest {
}
