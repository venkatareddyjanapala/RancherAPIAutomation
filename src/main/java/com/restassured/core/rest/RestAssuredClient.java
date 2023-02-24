package com.restassured.core.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import static com.restassured.core.rest.GenericRequestBuilder.requestCall;
import static io.restassured.RestAssured.requestSpecification;

@Slf4j
public class RestAssuredClient {
    public RequestSpecProvider requestSpecProvider  = new RequestSpecProvider();

    public static void getMethod(String endpoint) {
        log.info("===================URL is " + endpoint);
        return;
    }
    public Response postMethod(String baseURI, JSONObject jsonReqBody) {

        log.info("====================URL is " + baseURI);
        log.info("====================Request is " + jsonReqBody.toJSONString());
        requestSpecification.body(jsonReqBody.toString());
        Response response = requestCall(requestSpecification, Method.POST, baseURI);

        log.info("====================Response is " + response.prettyPrint());
       return response;
    }
    public RequestSpecification getRequestSpecification(){
        RequestSpecification requestSpecification=requestSpecProvider.createDefaultRequestSpecification();
        requestSpecification.body(RequestSpecProvider.getLogin());
        Response response = RestAssured.given().spec(requestSpecification).log().all().request("POST","/token" );

       String token=response.jsonPath().getString("jwt");
        requestSpecification.cookie("PL","rancher");
        requestSpecification.cookie("CSRF","F243AA6A11");
        requestSpecification.cookie("token", token);
        return requestSpecification;
    }
}
