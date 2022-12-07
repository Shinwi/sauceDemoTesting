package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepsDefinition extends AbstractStepsDef{
    @Given("the homepage is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @When("the login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.clickLoginButton();
    }

    @And("the password field is filled with {string}")
    public void thePasswordIsFilledWith(String arg0) {
        homePage.fillField("password", arg0);
    }
}
