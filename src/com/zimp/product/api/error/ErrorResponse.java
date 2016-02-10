package com.zimp.product.api.error;

import com.zimp.product.api.ResponseValidator;

import javax.xml.soap.Detail;

/**
 * Created by ninad on 19/01/16.
 */
public class ErrorResponse {
    public Integer statusCode;
    public String error;
    public String message;
    public Validation validation;
    public Details details;
}
