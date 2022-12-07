package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class addOneItemToCartStepDefinition extends AbstractStepsDef{
    /*
    * Scenario: Adding one item to shopping cart
    Given we are in the inventory page
    When add to cart button is clicked in one item
    Then the cart icon shows 1
    * */
    @Given("we are in the inventory page")
    public void currentPageIsInvetoryPage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String currentPage = driver.getCurrentUrl();
        if (currentPage.equals("https://www.saucedemo.com/inventory.html")) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }

    @When("add to cart button is clicked in one item")
    public void addOneItemToCart() {
        homePage.addOneItemToCart();
    }

    /*@When("add to cart button is clicked on two items")
    public void addTwoItemsToCart() {
        homePage.addTwoItemsToCart();
    }*/

    @Then("the cart icon shows {string}")
    public void cartIconShowsNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        int numberShownOnCart = homePage.getNumberShownOnCart();

        if (number == numberShownOnCart) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }
}
