package com.cuelogic.framework.network;

/**
 * Created by ninad on 14/01/16.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.cuelogic.framework.log.AutomationLog;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class HTTPHelper {

    private String getAllDataFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String data = new String();
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            data += buffer;
        }
        return  data;
    }

    private HTTPResponse convertAndSendResponse(HttpResponse libHTTPResponse) throws Exception {
        HTTPResponse response = new HTTPResponse();

        response.statusCode = libHTTPResponse.getStatusLine().getStatusCode();
        response.payload = getAllDataFromInputStream(libHTTPResponse.getEntity().getContent());

        AutomationLog.info("HTTP Status code received: " + response.statusCode);
        AutomationLog.info("Payload received: " + response.payload);

        return response;
    }

    public HTTPResponse sendPOSTRequest (HTTPRequest request) throws Exception {

        AutomationLog.info("Sending POST message to URL: " + request.url);
        AutomationLog.info("Sending payload: " + request.payload);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        StringEntity input = new StringEntity(request.payload);
        input.setContentType(request.contentType.toString());

        HttpPost postRequest = new HttpPost(request.url);
        postRequest.setEntity(input);
        postRequest.addHeader(request.authorization.get(0), request.authorization.get(1));
        HttpResponse response = httpClient.execute(postRequest);

        return convertAndSendResponse(response);
    }
}
