package com.restassured.core.helpers;

import com.restassured.core.common.CoreUtils;
import com.restassured.core.rest.RestAssuredClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

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
        System.out.println("THe URL Is:"+ URL);
        String baseURI = URL+"/token";
        System.out.println("the URL is:" + URL);
        JSONObject requestParams = new JSONObject();
        String userCode=userName+":"+password;
        requestParams.put("authProvider", "localauthconfig");
        requestParams.put("code", userCode);

      //  request.header("Content-Type", "application/json"); // Add the Json to the body of the request
   //     request.body(requestParams.toJSONString()); // Post the request and check the response
   //     Response response = request.post("/token");
        Response response = restClient.postMethod(baseURI,requestParams);
        System.out.println("The status received: " + response.statusLine());
        return response;
    }

}
