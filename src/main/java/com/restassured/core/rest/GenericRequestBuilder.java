package com.restassured.core.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class GenericRequestBuilder {
public static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    public static RequestSpecification getRequestSpecificationObject() {
        requestSpecBuilder.setRelaxedHTTPSValidation();
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.setContentType("application/json");
        return requestSpecBuilder.build();
    }
    public  static Response requestCall(RequestSpecification requestSpecification, Method method, String uri) {
        log.info("");
           Response responseData = RestAssured.given().spec(requestSpecification).log().all().request(method, uri);
           System.out.println("CURL REQUEST --> " + getCurl(requestSpecification));
        return responseData;
    }
    public static String getCurl(RequestSpecification requestSpecification) {
        StringBuilder curlBuilder = new StringBuilder();
        curlBuilder.append("curl --location --request ");
        curlBuilder.append(((RequestSpecificationImpl) requestSpecification).getMethod()+" ");
        curlBuilder.append("'"+((RequestSpecificationImpl) requestSpecification).getURI()+"' ");
        Headers headers = ((RequestSpecificationImpl) requestSpecification).getHeaders();
        for(Header h : headers) {
            curlBuilder.append("--header '"+h.getName()+":"+h.getValue()+"' ");
        }
        if(((RequestSpecificationImpl) requestSpecification).getBody() != null)
            curlBuilder.append("--data-raw '"+((RequestSpecificationImpl) requestSpecification).getBody()+"' ");
        return curlBuilder.toString();
    }

}
