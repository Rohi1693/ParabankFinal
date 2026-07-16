
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import factory.Driverfactory;

public class hooks {


    @Before
    public static void setUp() {
        Driverfactory.initDriver();
        Driverfactory.getDriver().manage().window().maximize();
    }

    @After
    public static void tearDown() {
        Driverfactory.quitDriver();
        }
    }

