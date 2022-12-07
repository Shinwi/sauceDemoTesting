package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.fail;

public class removeTwoItemsFromCartStepDefinition extends AbstractStepsDef{

    @And("the cart has one item")
    public void cartHasTwoItems() {
        homePage.addOneItemToCart();
        int numberShownOnCart = homePage.getNumberShownOnCart();

        if (numberShownOnCart == 1) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }

    @Then("the cart icon shows no number")
    public void cartIconShowsNoNumber() {
        int numberShownOnCart = homePage.getNumberShownOnCart();
        System.out.println(numberShownOnCart);
        if (numberShownOnCart == 0) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }

}
