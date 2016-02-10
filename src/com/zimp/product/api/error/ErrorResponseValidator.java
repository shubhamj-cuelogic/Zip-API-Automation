package com.zimp.product.api.error;

//import com.sun.tools.javac.code.Attribute;
import com.zimp.product.api.ResponseValidator;

/**
 * Created by ninad on 20/01/16.
 */
public class ErrorResponseValidator extends ResponseValidator {
    public ErrorResponse expectedResponse;
    public ErrorResponse actualResponse;

    public ErrorResponseValidator(ErrorResponse expectedResponse, ErrorResponse actualResponse) {
        this.expectedResponse = expectedResponse;
        this.actualResponse = actualResponse;
    }

    @Override
    public void validateActualVsExpectedResponse() throws Exception {
        validateRequiredString("Error message", expectedResponse.message, actualResponse.message);
        validateRequiredString("Error", expectedResponse.error, actualResponse.error);
        validateInteger("Status code", expectedResponse.statusCode, actualResponse.statusCode);
    }
}
