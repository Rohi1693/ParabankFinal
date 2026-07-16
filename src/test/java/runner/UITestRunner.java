package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/ui",
        glue = {"stepDefinition", "hooks"},
        tags = "@ui",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"}
)


public class UITestRunner extends AbstractTestNGCucumberTests {
}
