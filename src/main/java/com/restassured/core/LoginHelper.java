package com.restassured.core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class LoginHelper extends CoreUtils{
    public String URL;
    public String userName;
    public String password;
    public void getEnvironmentDetails(){
        URL = getEnvironmentURL();
        userName= getUserName();
        password= getPassword();
    }
    public Response getLogin(){
        RestAssured.baseURI = URL;
        System.out.println("the URL is:" + URL);
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation().when();

        JSONObject requestParams = new JSONObject();
        String userCode=userName+":"+password;
        requestParams.put("authProvider", "localauthconfig");
        requestParams.put("code", userCode);

        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString()); // Post the request and check the response
        Response response = request.post("/token");
        System.out.println("The status received: " + response.statusLine());
        return response;
    }

}
