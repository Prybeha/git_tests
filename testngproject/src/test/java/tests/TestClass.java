package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import tests.SupportClasses.SetupClass;
import utils.ExtentsReports.ExtentTestManager;

public class TestClass extends SetupClass {
    //private TestLinkResults Test = new TestLinkResults(); //object that used for update status in testlink
    private String TestLink_KEY = "b6b4dca82724b8b027b196c967472932";
    private String TestLink_URL = "http://localhost/testlink-1.9.18/lib/api/xmlrpc/v1/xmlrpc.php";
    private String Project_NAME = "FirstProject";
    private String Plan_NAME = "FirstTestPlan";
    private String Build_NAME = "FirstBuild";

    private String result = null;
    private String exception = null;

    @Test(groups = {"first"})
    public void First() throws Exception{
        ExtentTestManager.getTest().setDescription("First test");
        wait.until(ExpectedConditions.titleIs("Google"));
        String Expectedtitle = "Google";
        String Actualtitle = driver.getTitle();
        try {
            //assert Actualtitle.equals(Expectedtitle);
            result = TestLinkAPIResults.TEST_PASSED;
            updateTestLinkResult("FirstTestCase", exception, result);
        }
        catch(Exception ex){
            result = TestLinkAPIResults.TEST_FAILED;
            exception = ex.getMessage();
            updateTestLinkResult("FirstTestCase", exception, result);
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
    private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException {
        TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(TestLink_KEY, TestLink_URL);
        testlinkAPIClient.reportTestCaseResult(Project_NAME, Plan_NAME, testCase, Build_NAME, exception, result);
    }
}
