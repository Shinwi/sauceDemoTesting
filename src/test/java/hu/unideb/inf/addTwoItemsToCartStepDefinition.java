package hu.unideb.inf;

import io.cucumber.java.en.When;

public class addTwoItemsToCartStepDefinition extends AbstractStepsDef{

    @When("add to cart button is clicked on two items")
    public void addTwoItemsToCart() {
        homePage.addTwoItemsToCart();
    }
}
