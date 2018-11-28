package tests.SupportClasses;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestLinkResults {
    private String TestLink_KEY = "fcbe9e693f57d8f1035b8ebfd6584de6";
    private String TestLink_URL = "http://localhost/testlink-1.9.18/lib/api/xmlrpc/v1/xmlrpc.php";
    private String Project_NAME = "FirstProject";
    private String Plan_NAME = "FirstTestPlan";
    private String Build_NAME = "FirstBuild";

    private String result = null;
    private String exception = null;

    public void TestLinkFail(String TestCaseName, String e) throws Exception{
        result = TestLinkAPIResults.TEST_FAILED;
        exception = e;
        updateTestLinkResult(TestCaseName, exception, result);
    }

    public void TestLinkPass(String TestCaseName) throws Exception{
        result = TestLinkAPIResults.TEST_PASSED;
        updateTestLinkResult(TestCaseName, exception, result);
    }

    private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException {
        TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(TestLink_KEY, TestLink_URL);
        testlinkAPIClient.reportTestCaseResult(Project_NAME, Plan_NAME, testCase, Build_NAME, exception, result);
    }
}
