package tests.SupportClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SetupClass {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup (String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.marionette", "C:\\SeleniumDrivers\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setLogLevel(FirefoxDriverLogLevel.INFO);
            driver = new FirefoxDriver(options);
        }
        wait = new WebDriverWait(driver,5);
        driver.manage().window().maximize();
        driver.get("http://google.in");
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}