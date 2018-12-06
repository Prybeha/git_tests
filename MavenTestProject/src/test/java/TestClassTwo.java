import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import support.LogUtil;
import support.SetupClass;

import static org.testng.Assert.assertEquals;

public class TestClassTwo extends SetupClass {

    @Title("Title check")
    @Description("Checking the title of the loaded page.")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void searchTest(){
        String title = driver.getTitle();
        LogUtil.log("Title Fetched: "+title);
        assertEquals(title,"Google");
        LogUtil.log("Test Passed. Expected: Google | Actual: "+title);
        System.out.println("Page Loaded");
    }

    @Title("Second test")
    @Description("Find something in google")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void searchSomething(){
        driver.findElement(By.name("q")).sendKeys("Maven");
        driver.findElement(By.name("btnK")).click();
        LogUtil.log("Maven page request");
        assertEquals(driver.findElement(By.name("q")).getAttribute("value"),"Maven");
        LogUtil.log("URLs are equals.");
    }
}
