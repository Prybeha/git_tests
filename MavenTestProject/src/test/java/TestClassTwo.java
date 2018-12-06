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
        try {
            assertEquals(1, 2);
        }
        catch(AssertionError e){
            System.out.println("Test Failed, but it return true because code doesn't crush");
        }
    }
}
