package com.restassured.core.helpers;

import com.restassured.core.common.CoreUtils;
import com.restassured.core.rest.RestAssuredClient;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.util.HashMap;

@Slf4j
public class LoginHelper extends CoreUtils {
    public String URL;
    public String userName;
    public String password;
    public RestAssuredClient restClient = new RestAssuredClient();

    public void getEnvironmentDetails(){
        this.URL = getEnvironmentURL();
        this.userName= getUserName();
        this.password= getPassword();
    }

    public Response getLogin(){
        log.info("THe URL Is:"+ URL);
        String baseURI = URL+ LoginConstants.login;
        log.info("the API Request URL is:" + baseURI);
        JSONObject requestParams = new JSONObject();
        String userCode=userName+":"+password;

        HashMap<String,String> requestMap = new HashMap<>();
        requestMap.put("authProvider", "localauthconfig");
        requestMap.put("code", userCode);

        requestParams.put("authProvider", "localauthconfig");
        requestParams.put("code", userCode);
        Response response = restClient.postMethod(baseURI,requestParams);
        return response;
    }

}
