package hu.unideb.inf;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class addTwoItemsToCartStepDefinition extends AbstractStepsDef{

    @When("add to cart button is clicked on two items")
    public void addTwoItemsToCart() {
        if (driver.findElements(By.id("remove-sauce-labs-backpack")).size() > 0) {
            homePage.removeOneItemFromCart();
            homePage.addTwoItemsToCart();
        } else {
            homePage.addTwoItemsToCart();
        }
    }
}
