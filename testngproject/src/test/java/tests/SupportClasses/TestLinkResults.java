package tests.SupportClasses;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import org.apache.log4j.Logger;

public class TestLinkResults {
    private String TestLink_KEY = "7e820c3abf3dd74699ddfcad813dde84";
    private String TestLink_URL = "http://localhost/testlink-1.9.18/lib/api/xmlrpc/v1/xmlrpc.php";
    private String Project_NAME = "FirstProject";
    private String Plan_NAME = "FirstTestPlan";
    private String Build_NAME = "FirstBuild";

    private String result = null;
    private String exception = null;
    private static final Logger log = Logger.getLogger(TestLinkResults.class);

    public void TestLinkFail(String TestCaseName, String e) throws Exception{
        result = TestLinkAPIResults.TEST_FAILED;
        exception = e;
        updateTestLinkResult(TestCaseName, exception, result);
        log.error("Test case is failed");
    }

    public void TestLinkPass(String TestCaseName) throws Exception{
        result = TestLinkAPIResults.TEST_PASSED;
        updateTestLinkResult(TestCaseName, exception, result);
        log.info("Test case is passed");
    }

    private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException {
        TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(TestLink_KEY, TestLink_URL);
        testlinkAPIClient.reportTestCaseResult(Project_NAME, Plan_NAME, testCase, Build_NAME, exception, result);
    }
}
