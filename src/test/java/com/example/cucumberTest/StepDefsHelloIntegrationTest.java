package com.example.cucumberTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StepDefsHelloIntegrationTest extends SpringIntegrationTest {

    @When("^The client with name (.+) calls /hello$")
    public void theClientWithANameCallsHello(String nome) throws Throwable {
        executeGet("http://localhost:8080/hello?nome={nome}", nome);
    }

    @Then("^The client with name (.+) receives (.+)$")
    public void theClientWithANameReceivesHelloWorld(String nome, String expected) throws Throwable {
        assertThat(isExpectedHello(expected));
    }

    @When("^The client with no name calls /hello$")
    public void theClientWithNoNameCallsHello() throws Throwable {
        executeGet("http://localhost:8080/hello");
    }

    @Then("^The client with no name receives (.+)$")
    public void TheClientWithNoNameReceivesHelloWorld(String expected) throws Throwable {
        assertThat(isExpectedHello(expected));
    }
}
