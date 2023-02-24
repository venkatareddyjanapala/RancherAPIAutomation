package com.restassured.core.rest;

import com.restassured.core.helpers.LoginConstants;
import com.restassured.utils.ConfigProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.util.HashMap;

@Slf4j
public class RequestSpecProvider {
    public static ConfigProperties configProperties = ConfigProperties.getInstance();

    public static String getBasePath() {
        String basePath = null;
        if (System.getProperty("env.type").equals("QA")) {
            basePath = configProperties.getConfig("QA_BASE_URI");
        }
        return basePath;
    }

    public static String getPort() {
        String portnumber = "";
        if (System.getProperty("env.type").equals("QA")) {
            portnumber = configProperties.getConfig("QA_PORTNUMBER");
        }
        System.out.println("The port number is:" + portnumber);
        return portnumber;
    }
    public static JSONObject getLogin(){
            String baseURI = LoginConstants.login;
            log.info("the API Request URL is:" + baseURI);
            JSONObject requestParams = new JSONObject();
            String userCode= configProperties.getConfig("QA_USERNAME")+":"+ configProperties.getConfig("QA_PASSWORD");

            HashMap<String,String> requestMap = new HashMap<>();
            requestMap.put("authProvider", "localauthconfig");
            requestMap.put("code", userCode);

            requestParams.put("authProvider", "localauthconfig");
            requestParams.put("code", userCode);
            return requestParams;
    }

    public RequestSpecification createDefaultRequestSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setRelaxedHTTPSValidation();
        requestSpecBuilder.setPort(Integer.parseInt(getPort()));
        requestSpecBuilder.setBaseUri(getBasePath());
        requestSpecBuilder.setBasePath("/v2-beta/");
        return requestSpecBuilder.build();
    }
}
