package test.com.cuelogic.framework.network;

import org.junit.Assert;
import org.junit.Test;
//import sun.jvm.hotspot.utilities.AssertionFailure;
//import sun.jvm.hotspot.utilities.SystemDictionaryHelper;
import com.cuelogic.framework.network.Authorization;
import com.cuelogic.framework.network.ContentType;
import com.cuelogic.framework.network.HTTPHelper;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ninad on 14/01/16.
 */
public class HTTPHelperTest {

    @Test
    public void testSendPOSTRequest() {
        try {
            HTTPRequest request = new HTTPRequest();

            /*request.url = "https://staging-product.commerceconnect.co/api/products";
            request.contentType = ContentType.JSON;
            Map<String, String> foo = new HashMap<>();
            foo.put(Authorization.Type.toString(), "Token token=zkzg1VPnhcMm7mL9tBuv,email=cconnecttest7@gmail.com");
            request.setAuthorization(foo);
            request.payload = "{\"email\": \"gauravm@yopmail.com\",\"password\": \"Demo@12345\"}";*/
            

            request.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:5000/v1/users/login";
            request.contentType = ContentType.JSON;
            request.payload = "{\"email\": \"gauravm@yopmail.com\",\"password\": \"Demo@12345\"}";

            
            HTTPHelper helper = new HTTPHelper();
            HTTPResponse response = helper.sendPOSTRequest(request);
            
            System.out.println("POST Success");
            System.out.println("Response code: " +response.statusCode.toString());
            System.out.println("Payload: " +response.payload);
            assertTrue(true);
            
        } catch (Exception e) {
        	System.out.println(""+e.getMessage());
            assertTrue(false);
        } /*finally {
			System.out.println("Reached the finally block");	
		}*/
    }

}