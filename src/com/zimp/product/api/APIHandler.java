package com.zimp.product.api;

import com.cuelogic.framework.network.HTTPHelper;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;

/**
 * Created by ninad on 15/01/16.
 *
 * Base class for the the API's that would be impleted
 */
public abstract class APIHandler {

    public HTTPResponse sendHTTPPostRequest(HTTPRequest request) throws Exception {
        HTTPHelper httpClient = new HTTPHelper();
        return httpClient.sendPOSTRequest(request);
    }

    public boolean verifyHTTPCode(HTTPResponse response, int code) {
        return (response.statusCode.intValue() == code);
    }
}
