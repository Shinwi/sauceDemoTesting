package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.fail;

public class removeOneItemFromCart extends AbstractStepsDef{

    @And("the cart has two items")
    public void cartHasTwoItems() {
        homePage.removeTwoItemsFromCart();
        homePage.addTwoItemsToCart();
        int numberShownOnCart = homePage.getNumberShownOnCart();

        if (numberShownOnCart == 2) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }

    @When("remove button is clicked on one item")
    public void removeOneItemFromCart() {
        homePage.removeOneItemFromCart();
    }

}
