package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import static org.junit.Assert.fail;

public class successfulLoginStepDefinition extends AbstractStepsDef{

    @Given("the username field is filled with {string}")
    public void theUserNameFieldIsFilledWith(String arg0) {
        homePage.fillField("user-name", arg0);
    }

    @Then("the page url changes to {string}")
    public void thePageUrlChangesTo(String arg0) {
        String currentPageUrl = homePage.getCurrentPageUrl();
        if (!currentPageUrl.isEmpty()) {
            Assert.assertEquals(arg0, currentPageUrl);
        } else {
            fail();
        }
    }
}
