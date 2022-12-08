package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.fail;

public class removeTwoItemsFromCartStepDefinition extends AbstractStepsDef{

    @And("the cart has one item")
    public void cartHasTwoItems() {
        if (driver.findElements(By.id("remove-sauce-labs-backpack")).size() > 0) {
            // removeBackPackFromCartButton.click();
            homePage.removeOneItemFromCart();
        }
        else if (driver.findElements(By.id("remove-sauce-labs-bike-light")).size() > 0) {
            // removeBikeLightFromCartButton.click();
            homePage.removeSauceLabsBikeLight();
        }
        // homePage.removeTwoItemsFromCart();
        homePage.addTwoItemsToCart();

        int numberShownOnCart = homePage.getNumberShownOnCart();
        System.out.println("number shown on cart");
        System.out.println(numberShownOnCart);

        if (numberShownOnCart == 2) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }

    /* @Then("the cart icon shows {string}")
    public void cartIconShowsNoNumber(String givenNumber) {
        int numberToBeShown = Integer.parseInt(givenNumber);
        int numberShownOnCart = homePage.getNumberShownOnCart();
        System.out.println("icon shw number");
        System.out.println(numberShownOnCart);
        if (numberShownOnCart == numberToBeShown) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }*/

}
