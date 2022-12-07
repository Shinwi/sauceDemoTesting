package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class performanceGlitchStepDefinition extends AbstractStepsDef{

    @Given("the username is filled with the value {string}")
    public void theUserNameIsFilledWith(String parameter) {
        homePage.fillField("user-name", parameter);
    }

    @Then("the page url changes to this {string} only after more than 2 seconds")
    public void urlPageChange(String url) {
        long start = System.nanoTime();
        homePage.clickLoginButton();
        homePage.getCurrentPageUrl();
        long elapsedTime = System.nanoTime() - start;
        long convertedTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        if (convertedTime > 2) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}
