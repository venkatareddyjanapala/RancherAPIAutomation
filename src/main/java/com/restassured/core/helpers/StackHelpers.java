package com.restassured.core.helpers;

import com.google.gson.JsonObject;
import com.restassured.core.common.CoreUtils;
import com.restassured.core.rest.GenericRequestBuilder;
import io.harness.rest.utils.JsonFileReader;
import io.restassured.response.Response;

import java.io.FileNotFoundException;

public class StackHelpers extends CoreUtils {
    public static JsonFileReader jReader = new JsonFileReader();
    GenericRequestBuilder genericRequestBuilder = new GenericRequestBuilder();
    public Response createStack(String projectName,String stackName) throws FileNotFoundException {
        JsonObject appReqData = jReader.readJSONFiles(LoginConstants.CREATE_STACK_JSON);
        appReqData.addProperty("name", stackName);
        Response applicationResponse =
                genericRequestBuilder.postCall(appReqData,projectName, LoginConstants.CREATE_STACK);
        return applicationResponse;
    }
}
