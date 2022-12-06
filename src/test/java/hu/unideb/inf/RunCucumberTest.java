package hu.unideb.inf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/hu.unideb.inf"},
        plugin = {"pretty"}
)
public class RunCucumberTest {
}
