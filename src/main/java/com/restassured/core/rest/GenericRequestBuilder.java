package com.restassured.core.rest;

import com.google.gson.JsonObject;
import com.restassured.utils.ConfigProperties;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class GenericRequestBuilder {
public  static ConfigProperties configProperties = ConfigProperties.getInstance();
static  RestAssuredClient restAssuredClient  = new RestAssuredClient();
    public static RequestSpecification getRequestSpecificationObject() {
        RequestSpecification requestSpecification = restAssuredClient.getRequestSpecification();
        return requestSpecification;
    }

    public  static Response requestCall(RequestSpecification requestSpecification, Method method, String uri) {
        log.info("");
        Response responseData = RestAssured.given().spec(requestSpecification).log().all().request(method, uri);
        System.out.println("CURL REQUEST --> " + getCurl(requestSpecification));
        System.out.println("Response  --> " + responseData.prettyPrint());

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
    public  Response postCall(JsonObject jsonObject, String projectId,String uri) {
        RequestSpecification requestSpecification = getRequestSpecificationObject();
        requestSpecification.pathParam("projectId",projectId);
        requestSpecification.body(jsonObject.toString());
        return requestCall(requestSpecification, Method.POST, uri);
    }
    public  Response postCallWithCookie(JsonObject jsonObject, String projectId,String uri,String token) {
        RequestSpecification requestSpecification = getRequestSpecificationObject();
        requestSpecification.pathParam("projectId",projectId);
        String cookie= "token="+token;
        requestSpecification.cookie("PL","rancher");
        requestSpecification.cookie("CSRF","F243AA6A11");
        requestSpecification.cookie("token", token);

        requestSpecification.body(jsonObject.toString());
        return requestCall(requestSpecification, Method.POST, uri);
    }
    public static String getBasePath(){
        String basePath = null;
        if(System.getProperty("env.type").equals("QA")){
            basePath=configProperties.getConfig("QA_BASE_URI");
        }
        return basePath;
    }
    public static String getPort(){
        String portnumber = "";
        if(System.getProperty("env.type").equals("QA")){
             portnumber = configProperties.getConfig("QA_PORTNUMBER");
        }
        System.out.println("The port number is:" + portnumber);
        return portnumber;
    }
}
