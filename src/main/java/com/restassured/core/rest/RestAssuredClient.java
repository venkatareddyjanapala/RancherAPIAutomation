package com.restassured.core.rest;

import com.restassured.core.common.CoreUtils;
import com.restassured.core.helpers.LoginHelper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import static com.restassured.core.rest.GenericRequestBuilder.requestCall;

@Slf4j
public class RestAssuredClient {
    RequestSpecification requestSpecification = GenericRequestBuilder.getRequestSpecificationObject();

    public static void getMethod(String endpoint) {
        log.info("===================URL is " + endpoint);
        return;
    }

    public Response postMethod(String baseURI, JSONObject jsonReqBody) {

        log.info("====================URL is " + baseURI);
        log.info("====================Request is " + jsonReqBody.toJSONString());
        requestSpecification.body(jsonReqBody.toString());
        requestSpecification.baseUri(baseURI);
        Response response = requestCall(requestSpecification, Method.POST, baseURI);
        // Response response = requestSpecification.log().all().request(Method.POST, baseURI);

        log.info("====================Response is " + response.prettyPrint());
        //String json = response.asString();
       // System.out.println("returned json: " + json);
        //return new JsonPath(json);
        return response;
    }
}
