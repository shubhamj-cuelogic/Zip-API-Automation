package test.com.zimp.product.api.login;

import com.cuelogic.framework.AutomationFramework;
import com.zimp.product.api.error.Details;
import com.zimp.product.api.error.ErrorResponse;
import com.zimp.product.api.login.LoginAPI;
import com.zimp.product.api.login.LoginRequest;
import com.zimp.product.api.login.LoginResponse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginAPITest {
    @Before
    public void setup() {
//        AutomationFramework.initWithGlobalConfiguration("out/com/zimp/product/configuration/config.properties");
    }

    @Test
    public void testLoginVerifySuccess() {
        try {
            LoginAPI login = new LoginAPI();

            LoginRequest request = new LoginRequest();
            request.email = "gaurav@cuelogic.com";
            request.password = "asdf123";

            LoginResponse expectedResponse = new LoginResponse();
            expectedResponse.email = "gaurav@cuelogic.com";
            expectedResponse.fname = "Gaurv";
            expectedResponse.lname = "NA";
            expectedResponse.isVerified = true;

            login.loginVerifySuccess(request, expectedResponse);

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testInvalidLoginErrorResponse() {
        try {
            LoginAPI login = new LoginAPI();

            LoginRequest request = new LoginRequest();
            request.email = "gaurav@cuelogic.com";
            request.password = "1111asdf123";

            ErrorResponse expectedError = new ErrorResponse();
            expectedError.statusCode = 401;
            expectedError.error = "Unauthorized";
            expectedError.message = "Login failed";

            Details details = new Details();
            details.code = 13103;
            details.message = "Invalid password";
            expectedError.details = details;

            expectedError.validation = null;

            login.loginVerifyFailure(request, 401, expectedError);

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}