package hooks;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {

    @Before
    public void setUp() {
        Driverfactory.initDriver();
        Driverfactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driverfactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());
        }

        Driverfactory.quitDriver();
    }
}