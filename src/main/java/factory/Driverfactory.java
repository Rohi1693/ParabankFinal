package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driverfactory {
    public static WebDriver driver;


    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initialize driver
    public static void initDriver() {
        tlDriver.set(new ChromeDriver());

    }

    // Get driver
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quit driver
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }


    }
}
