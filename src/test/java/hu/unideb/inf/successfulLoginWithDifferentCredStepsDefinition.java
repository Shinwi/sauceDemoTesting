package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class successfulLoginWithDifferentCredStepsDefinition extends AbstractStepsDef{
    private String userName;

    @Given("the {string} is filled with the value {string}")
    public void theUserNameIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
        userName = parameter;
    }

    @And("the password is filled with value {string}")
    public void thePasswordIsFilledWithValue(String arg0) {
        homePage.fillField("password", arg0);
    }

    @Then("this {string} error message is shown if user is locked out")
    public void theLockedUserErrorMessageIsShown(String message) {
        if (userName.equals("locked_out_user")) {
            Optional<String> errorMessage = homePage.getLoginError();
            if (errorMessage.isPresent()) {
                Assert.assertEquals(message, errorMessage.get());
            } else {
                fail();
            }
        } else {
            assertTrue(true);
        }

    }

    @Then("the page url changes to this {string}")
    public void thePageUrlChangesTo(String arg0) {
        if (!userName.equals("locked_out_user")) {
            String currentPageUrl = homePage.getCurrentPageUrl();
            if (!currentPageUrl.isEmpty()) {
                Assert.assertEquals(arg0, currentPageUrl);
            } else {
                fail();
            }
        } else {
            assertTrue(true);
        }

    }
}
