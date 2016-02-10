package com.zimp.product.api;

import com.cuelogic.framework.log.AutomationLog;
//import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;
//import com.sun.javaws.exceptions.ExitException;

/**
 * Created by ninad on 19/01/16.
 */
public abstract class ResponseValidator {


    public abstract void validateActualVsExpectedResponse() throws Exception;

    private void validateNULL(String header, Object expected, Object actual) throws Exception {
        if (expected == null && actual == null) {
            return;
        } else if (expected == null) {
            throw generateException(header, expected, actual);
        } else if (actual == null) {
            throw generateException(header, expected, actual);
        }
    }

    private void validateString(String header, String expected, String actual) throws Exception {
        validateNULL(header, expected, actual);

        if (expected == null || actual == null) return;

        if (!expected.contentEquals(actual)) {
            logValidationFailedHeader(header);
            logValidationMismatch(header, expected, actual);
            throw generateException(header, expected, actual);
        } else {
            logValidationSuccess(header);
        }
    }

    private void validateStringLenght(String header, String actualResponse, int expectedLength) {
        if (actualResponse.length() != expectedLength) {
            logValidationFailedHeader(header);
            logValidationMismatchLenght(header, actualResponse, expectedLength);
        } else {
            logValidationSuccess(header);
        }
    }

    private Exception generateException(String header, Object expected, Object actual) {
        return new Exception(header + " validation falied. Expected: " + expected + " actual: " + actual);
    }

    private Exception generateException(String header, String expected, String actual) {
        return new Exception(header + " validation falied. Expected: " + expected + " actual: " + actual);
    }

    private void logValidationMismatch(String header, String expected, String actual) {
        AutomationLog.error(header + " Actual Value: " + actual + " ,Expected Value: " + expected);
    }

    private void logValidationMismatch(String header, int expected, int actual) {
        AutomationLog.error(header + " Actual Value: " + actual + " ,Expected Value: " + expected);
    }

    private void logValidationMismatchLenght(String header, String actual, int expectedLength) {
        AutomationLog.error(header + " value: " + actual + " Expected length: " + expectedLength + " Actual length: " + actual.length());
    }

    private void logValidationFailedHeader(String header) {
        AutomationLog.error(header + " validation failed");
    }

    private void logValidationSuccess(String header) {
        AutomationLog.info(header + " validation successful");
    }


    protected void validateRequiredString(String header, String expected, String actual) throws Exception {
        if (expected == null || actual == null) throw new NullPointerException();
        validateString(header, expected, actual);
    }

    protected void validateOptionalString(String header, String expected, String actual) throws Exception {
        validateNULL(header, expected, actual);
        if (expected == null || actual == null) return;
        validateString(header, expected, actual);
    }

    protected void validateRequiredStringLenght(String header, String actual, int expectedLenght) throws Exception {
        if (actual == null) throw new NullPointerException();
        validateStringLenght(header, actual, expectedLenght);
    }

    protected void validateOptionalStringLenght(String header, String actual, int expectedLenght) throws Exception {
        if (actual == null) return;
        validateStringLenght(header, actual, expectedLenght);
    }

    protected void validateInteger(String header, int expected, int actual) throws Exception {
        if (expected != actual) {
            logValidationFailedHeader(header);
            logValidationMismatch(header, expected, actual);
        }
    }

}
