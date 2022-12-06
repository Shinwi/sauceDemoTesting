package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {
    private static final String PageURL = "https://www.saucedemo.com/";
    private WebDriver driver;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    private static final By loginError = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PageURL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() { loginButton.click();}

    public void fillField(String field, String value) { getField(By.id(field)).sendKeys(value); }

    public WebElement getField(By locator) { return driver.findElement(locator); }

    public Optional<String> getLoginError() { return getErrorMessage(loginError);}

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
