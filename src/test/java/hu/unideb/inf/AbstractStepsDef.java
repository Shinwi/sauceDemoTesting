package hu.unideb.inf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractStepsDef {
    private static final int WaitTime = 10;

    static WebDriver driver;

    protected static HomePage homePage;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }
}
