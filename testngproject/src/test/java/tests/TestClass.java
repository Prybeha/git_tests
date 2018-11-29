package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import tests.SupportClasses.SetupClass;
import utils.ExtentsReports.ExtentTestManager;

public class TestClass extends SetupClass {
    //private TestLinkResults Test = new TestLinkResults(); //object that used for update status in testlink

    @Test(groups = {"first"})
    public void First() throws Exception{
        ExtentTestManager.getTest().setDescription("First test");
        wait.until(ExpectedConditions.titleIs("Google"));
        String Expectedtitle = "Google";
        String Actualtitle = driver.getTitle();
        try {
            assert Actualtitle.equals(Expectedtitle);
            //Test.TestLinkPass("FirstTestCase");
        }
        catch(Exception ex){
            //Test.TestLinkFail("FirstTestCase", ex.getMessage());//Send error massage
        }
    }

    @Test(groups = {"second"})
    public void Second() throws Exception{
        ExtentTestManager.getTest().setDescription("Second test");
        try {
            System.out.println(driver.getCurrentUrl());
            //Test.TestLinkPass("SecondTestCase");
        }
        catch(Exception ex){
            //Test.TestLinkFail("SecondTestCase", ex.getMessage());//Send error massage
        }
    }

    @Test(groups = {"third"})
    public void Third() throws Exception{
        ExtentTestManager.getTest().setDescription("Third test");
        try {
            System.out.println(driver.getCurrentUrl());
            //Test.TestLinkPass("ThirdTestCase");
        }
        catch(Exception ex){
            //Test.TestLinkFail("ThirdTestCase", ex.getMessage());//Send error massage
        }
    }
}
