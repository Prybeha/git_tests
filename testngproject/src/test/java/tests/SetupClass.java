package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupClass {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.get("http://google.in");
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}