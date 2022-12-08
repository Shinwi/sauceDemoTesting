package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;


import static org.junit.Assert.fail;

public class SocialLinksStepDefinition extends AbstractStepsDef{
    String openedPageUrl;

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
        openedPageUrl = homePage.clickButtonByClassName(socialIconClassName);
        System.out.println(openedPageUrl);
    }

    @Then("the opened page url is equal to {string}")
    public void newPageUrl(String newPageUrl) {
        // OpenedPageUrl  equal newPageUrl?
        if (openedPageUrl.contains("linkedin.com") && openedPageUrl.contains("sauce-labs")) {
            Assert.assertTrue(true);
        }
        else if (openedPageUrl.equals(newPageUrl)) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }
}
