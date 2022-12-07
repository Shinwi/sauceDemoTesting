package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class SocialLinksStepDefinition extends AbstractStepsDef{
    /*
    * Given the '<socialIcon>' exists in the page
    And the '<socialIcon>' is clicked
    Then the opened page url is equal to '<newPageUrl>'
    * */
    @Given("the {string} exists in the page")
    public void doesSocialIconExist(String socialIconClassName) {
        try {
            homePage.getFieldByClassName(socialIconClassName);
        } catch (NoSuchElementException e) {
            fail();
        }
        Assert.assertTrue(true);
    }

    @And("the {string} icon is clicked")
    public void clickSocialIcon(String socialIconClassName) {
        homePage.clickButtonByClassName(socialIconClassName);
        String dino = homePage.getNewTabUrl();
        System.out.println(dino);
    }
    // @Then("the opened page url is equal to {string}")
}
