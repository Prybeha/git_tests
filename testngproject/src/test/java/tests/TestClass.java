package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExtentsReports.ExtentTestManager;

public class TestClass extends SetupClass{

    @Test(groups = {"first"})
    public void First(){
        ExtentTestManager.getTest().setDescription("First test");
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
        ExtentTestManager.getTest().setDescription("Second test");
        //Assert.assertEquals("1","2");
        System.out.println(driver.getCurrentUrl());
    }

    @Test(groups = {"third"})
    public void Third(){
        ExtentTestManager.getTest().setDescription("First test");
        System.out.println("Third test is started");
    }
}
