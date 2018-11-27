import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestClass {
    private static WebDriver driver;

    @BeforeClass
    public static void BeforeActions(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void TestSearch(){
        driver.get("http://google.in");
        String Expectedtitle = "Google";
        String Actualtitle = driver.getTitle();
        System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
        Assert.assertEquals(Actualtitle, Expectedtitle);
        System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
    }

    @AfterClass
    public static void AfterActions(){
        driver.quit();
    }
}