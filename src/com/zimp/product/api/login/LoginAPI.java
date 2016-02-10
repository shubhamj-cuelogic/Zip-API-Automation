package com.zimp.product.api.login;

import com.cuelogic.framework.json.JSONFactory;
import com.cuelogic.framework.network.ContentType;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;
import com.zimp.product.api.APIHandler;
import com.zimp.product.api.error.ErrorResponse;
import com.zimp.product.api.error.ErrorResponseValidator;


/**
 * Created by ninad on 15/01/16.
 */
public class LoginAPI extends APIHandler {

    private HTTPRequest generateLoginRequest (LoginRequest loginRequest) throws Exception {

        HTTPRequest httpRequest = new HTTPRequest();
        httpRequest.contentType = ContentType.JSON;
        httpRequest.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/users/login"; // Generate URL
        httpRequest.payload = JSONFactory.factory().toJSON(loginRequest);
        return httpRequest;
    }

    public boolean loginVerifySuccess(LoginRequest request, LoginResponse expectedResponse) throws Exception{
        HTTPResponse httpResponse = sendHTTPPostRequest(generateLoginRequest(request));

        if (verifyHTTPCode(httpResponse, 200) == true) {
            LoginResponse response = JSONFactory.factory().fromJSON(httpResponse.payload, LoginResponse.class);
            LoginResponseValidator validator = new LoginResponseValidator(expectedResponse, response);
            validator.validateActualVsExpectedResponse();
        } else {
            Exception e = new Exception("Login request failed");
            throw e;
        }

        return true;
    }

    public boolean loginVerifyFailure(LoginRequest request, int expectedHTTPStatusCode, ErrorResponse expectedError) throws Exception {
        HTTPResponse httpResponse = sendHTTPPostRequest(generateLoginRequest(request));

        if (verifyHTTPCode(httpResponse, expectedHTTPStatusCode) == true) {
            ErrorResponse response = JSONFactory.factory().fromJSON(httpResponse.payload, ErrorResponse.class);
            ErrorResponseValidator responseValidator = new ErrorResponseValidator(expectedError, response);
            responseValidator.validateActualVsExpectedResponse();
        } else {
            Exception e = new Exception("HTTP Status code mis-match");
            throw e;
        }
        return true;
    }
}
