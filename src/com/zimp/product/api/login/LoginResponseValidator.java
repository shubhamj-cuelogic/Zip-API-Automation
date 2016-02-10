package com.zimp.product.api.login;

import com.cuelogic.framework.log.AutomationLog;
//import com.sun.javaws.exceptions.ExitException;
import com.zimp.product.api.ResponseValidator;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginResponseValidator extends ResponseValidator {

    private LoginResponse expectedResponse;
    private LoginResponse actualResponse;

    public LoginResponseValidator(LoginResponse expectedResponse, LoginResponse actualResponse) {
        this.expectedResponse = expectedResponse;
        this.actualResponse = actualResponse;
    }

    @Override
    public void validateActualVsExpectedResponse() throws Exception {
        validateRequiredString("Login email", expectedResponse.email, actualResponse.email);
        validateRequiredString("Login fname", expectedResponse.fname, actualResponse.fname);
        validateRequiredString("Login lname", expectedResponse.lname, actualResponse.lname);
        validateRequiredStringLenght("Login authToken", actualResponse.authToken, 60);
        validateRequiredStringLenght("Login id", actualResponse.id, 36);
    }
}
