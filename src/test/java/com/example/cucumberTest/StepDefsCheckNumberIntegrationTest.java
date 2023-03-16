package com.example.cucumberTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StepDefsCheckNumberIntegrationTest extends SpringIntegrationTest {

    @When("^The client send the body request (.+) with a number$")
    public void theClientSendTheBodyRequestRequestWithANumber(String request) throws Exception {
        executePost("http://localhost:8080/checkNumber", request);
    }


    @Then("^The client receives (.+)$")
    public void theClientReceivesExpected(String expected) throws Exception {
        assertThat(isExpectedCheckNumber(expected));
    }
}
