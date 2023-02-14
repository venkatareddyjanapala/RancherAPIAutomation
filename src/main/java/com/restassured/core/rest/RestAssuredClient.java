package com.restassured.core.rest;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import static com.restassured.core.rest.GenericRequestBuilder.requestCall;

@Slf4j
public class RestAssuredClient {
    static RequestSpecification requestSpecification =  GenericRequestBuilder.getRequestSpecificationObject();
    public static Response getMethod(String baseURI) {
        log.info("===================URL is " + baseURI);
        Response response =  requestCall(requestSpecification, Method.GET, baseURI);
        return response;
    }
/*
    public Response postMethod(String baseURI, JSONObject json) {

        log.info("====================URL is " + baseURI);
        log.info("====================Request is " + json.toString());
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation();
       // requestSpecification.request(HttpOperations.POST);
        Response response = requestSpecification
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().post(baseURI)
                .then()
                .and().log().all()
                .extract().response();
       log.info("====================Response is " + response.toString());
        return response;
    }

 */
    public Response postMethod(String baseURI, JSONObject jsonReqBody) {

        log.info("====================URL is " + baseURI);
        log.info("====================Request is " + jsonReqBody.toJSONString());
        requestSpecification.body(jsonReqBody.toString());
       // requestSpecification.baseUri(baseURI);
         Response response =  requestCall(requestSpecification, Method.POST, baseURI);
        log.info("====================Response is " + response.toString());
        return response;
    }
}
