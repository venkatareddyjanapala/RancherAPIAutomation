package com.restassured.core.helpers;

import com.restassured.core.common.CoreUtils;
import com.restassured.core.rest.RestAssuredClient;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

public class LoginHelper extends CoreUtils {
    public String URL;
    public String userName;
    public String password;
    public RestAssuredClient restClient = new RestAssuredClient();
    Logger log = Logger.getLogger(LoginHelper.class);

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
        requestParams.put("authProvider", "localauthconfig");
        requestParams.put("code", userCode);
        Response response = restClient.postMethod(baseURI,requestParams);
        return response;
    }

}
