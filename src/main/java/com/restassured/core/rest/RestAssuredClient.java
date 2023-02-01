package com.restassured.core.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

public class RestAssuredClient {
    static Logger log = Logger.getLogger(RestAssuredClient.class);

    public static Response getMethod(String endpoint) {

        //using Requestspecification class
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation();
        log.info("===================URL is " + endpoint);
        requestSpecification.contentType("application/json");
        return requestSpecification.get(endpoint).then().log().all().and().extract().response();
    }

    public Response postMethod(String baseURI, JSONObject json) {

        log.info("====================URL is " + baseURI);
        log.info("====================Request is " + json.toString());
        Response response = RestAssured.given().relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().post(baseURI)
                .then()
                .and().log().all()
                .extract().response();
       log.info("====================Response is " + response.toString());
        return response;
    }
}
