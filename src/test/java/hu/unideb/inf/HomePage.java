package hu.unideb.inf;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private static final String PageURL = "https://www.saucedemo.com/";
    private WebDriver driver;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackPackFromCartButton;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;
    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeBikeLightFromCartButton;

    private static final By loginError = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PageURL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() { loginButton.click();}

    public void addOneItemToCart() {
        addBackpackToCartButton.click();
    }

    public void addTwoItemsToCart() {
        addBackpackToCartButton.click();
        addBikeLightToCartButton.click();
    }

    public void removeOneItemFromCart() { removeBackPackFromCartButton.click(); }

    public void removeSauceLabsBikeLight() { removeBikeLightFromCartButton.click(); }
    public void removeTwoItemsFromCart() {
        removeBackPackFromCartButton.click();
        removeBikeLightFromCartButton.click();
        /*
        if (driver.findElements(By.id("remove-sauce-labs-backpack")).size() > 0) {
            removeBackPackFromCartButton.click();
        }
        else if (driver.findElements(By.id("remove-sauce-labs-bike-light")).size() > 0) {
            removeBikeLightFromCartButton.click();
        } */
    }

    public int getNumberShownOnCart() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if (driver.findElements(By.className("shopping_cart_badge")).size() > 0) {
            return Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());
        } else {
            return 0;
        }
    }

    public void fillField(String field, String value) { getField(By.id(field)).sendKeys(value); }

    public WebElement getField(By locator) { return driver.findElement(locator); }

    // find the element in the page by classname
    public WebElement getFieldByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    // takes a class, find the element of that class, and clicks it
    public String clickButtonByClassName(String className) {
        driver.findElement(By.className(className)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String openedTabUrl =  driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return openedTabUrl;
    }

    public Optional<String> getLoginError() { return getErrorMessage(loginError);}

    public String getCurrentPageUrl() { return driver.getCurrentUrl(); }

    // focuses on the new opened tab, copies its url, then close the tab and go back to original one
    public String getNewTabUrl() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");
        String pageUrl = driver.getCurrentUrl();
        System.out.println("ada");
        System.out.println(pageUrl);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
        // driver.switchTo()
        return pageUrl;
    }

    private Optional<String> getErrorMessage(By loginErrorLocator) {
        Optional<WebElement> error = getError(loginErrorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }
    private Optional<WebElement> getError(By loginErrorLocator) {
        List<WebElement> elements = driver.findElements(loginErrorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}
