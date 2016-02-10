package com.cuelogic.framework.testscript;

import com.cuelogic.framework.configuration.Configuration;
import com.cuelogic.framework.configuration.Credentials;
import com.cuelogic.framework.configuration.TestDataProvider;
import com.cuelogic.framework.log.AutomationLog;

import java.util.HashMap;

/**
 * Created by ninad on 15/01/16.
 */
public class testscript {

    private String executingTestScriptName = null;

    protected HashMap<String, HashMap<String, String>> testCaseData;
    private String executingTestCaseFileName = null;

    public testscript()
    {
        this.executingTestScriptName = this.getClass().getSimpleName();
        this.executingTestCaseFileName = executingTestScriptName;
    }

    protected testscript(String executingTestScriptName)
    {
        this.executingTestScriptName = this.getClass().getSimpleName();
        this.executingTestCaseFileName = executingTestScriptName;
    }

    public void setup()
    {
        AutomationLog.startTestCase(executingTestScriptName);
        // populate test case data from csv
        testCaseData = TestDataProvider.getTestData(executingTestCaseFileName);
    }

    public Credentials userCredentials()
    {
        String email = Configuration.getConfigurationValueForProperty("email");
        String password = Configuration.getConfigurationValueForProperty("password");
        Credentials credential =new Credentials(email, password);
        return credential;
    }

    public void cleanup()
    {
        AutomationLog.endTestCase(executingTestScriptName);

        if (testCaseData != null)
            testCaseData.clear();

    }

    public void testcasePassed(String customMessage)
    {
        AutomationLog.info(executingTestScriptName + " " + customMessage);
    }

    public void testcaseFailed(String customMessage)
    {
        AutomationLog.info(executingTestScriptName + " " + customMessage);
    }
}
