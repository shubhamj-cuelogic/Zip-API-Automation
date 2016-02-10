package com.cuelogic.framework.testscript;

import com.cuelogic.framework.log.AutomationLog;

/**
 * Created by ninad on 15/01/16.
 */
public abstract class TestScriptVerification extends testscript {
    protected TestScriptVerification(String executingTestCase)
    {
        super(executingTestCase);
    }

    public TestScriptVerification()
    {
        super();
    }

    public void setup()
    {
        super.setup();
    }

    public void cleanup()
    {
        super.cleanup();
    }

    protected abstract void verifyTestCases() throws Exception;
    protected abstract String successMessage();
    protected abstract String failureMessage();

    public void Execute() throws Exception
    {
        try
        {
            setup();
            verifyTestCases();
            testcasePassed(successMessage());
        }
        catch(Exception e)
        {
            handleTestCaseFailure(e.getMessage());
        }
        catch(Throwable throwable)
        {
            handleTestCaseFailure(throwable.getMessage());
        }
        finally
        {
            cleanup();
        }
    }

    private void handleTestCaseFailure(String message) throws Exception
    {
        AutomationLog.error(message);
        testcaseFailed(failureMessage());
        throw (new Exception(message));
    }
}
