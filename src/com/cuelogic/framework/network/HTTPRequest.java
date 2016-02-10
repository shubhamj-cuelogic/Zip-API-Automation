package com.cuelogic.framework.network;

import java.util.Map;

/**
 * Created by ninad on 14/01/16.
 */


public class HTTPRequest {
    public String url;
    public ContentType contentType;
    public String payload;
    public Map<String, String> authorization;
    
	public Map<String, String> getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Map<String, String> authorization) {
		this.authorization = authorization;
	}
    
    
    
}
