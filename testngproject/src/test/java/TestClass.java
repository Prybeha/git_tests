import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod
    public static void BeforeActions(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.get("http://google.in");
    }

    @Test(groups = {"first"})
    public void First(){
        wait.until(ExpectedConditions.titleIs("Google"));
        String Expectedtitle = "Google";
        String Actualtitle = driver.getTitle();
        System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
        try {
            assert Actualtitle.equals(Expectedtitle);
            System.out.println("OK");
        }
        catch(Exception e){
            System.out.println("Error");
        }
        System.out.println("first");
        System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
    }

    @Test(groups = {"second"})
    public void Second(){
        //Assert.assertEquals("1","2");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void Third(){
        System.out.println("Third test is started");
    }

    @AfterMethod
    public static void AfterActions(){
        driver.quit();
    }
}
