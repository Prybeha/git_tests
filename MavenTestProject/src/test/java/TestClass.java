import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import static org.testng.Assert.assertEquals;

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

    @Title("Title check")
    @Description("Checking the title of the loaded page.")
    @Test
    public void searchTest(){
        wait.until(ExpectedConditions.titleIs("Google"));
        String title = driver.getTitle();
        LogUtil.log("Title Fetched: "+title);
        assertEquals(title,"Google123");
        LogUtil.log("Test Passed. Expected: Google | Actual: "+title);
        System.out.println("Page Loaded");
    }

    @Title("Second test")
    @Description("Find some thing in google")
    @Test
    public void searchSomething(){
        wait.until(ExpectedConditions.titleIs("Google"));
        driver.findElement(By.name("q")).sendKeys("Maven");
        driver.findElement(By.name("btnK")).click();
        LogUtil.log("Maven page request");
        assertEquals(driver.getCurrentUrl(),"https://www.google.co.in/search?source=hp&ei=YDIJXLbCIIiTsAG165eQBw&q=Maven&btnK=%D0%9F%D0%BE%D1%88%D1%83%D0%BA+Google&oq=Maven&gs_l=psy-ab.3..0l10.111011.116882..117455...6.0..0.73.790.12......0....1..gws-wiz.....0..0i131j0i10.OIF_djpsDJE");
        LogUtil.log("URLs are equals.");
    }

    @AfterMethod
    public static void AfterActions(){
        driver.quit();
    }
}