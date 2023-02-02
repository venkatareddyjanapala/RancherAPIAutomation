package com.restassured.core.common;

import com.restassured.core.rest.RestAssuredClient;
import com.restassured.utils.ConfigProperties;
import org.apache.log4j.Logger;

public abstract class CoreUtils {

    public static ConfigProperties configProperties = ConfigProperties.getInstance();
    static Logger log = Logger.getLogger(RestAssuredClient.class);

    public String getEnvironmentURL() {
        return configProperties.getConfig("QA_BASE_URI")+":"+configProperties.getConfig("QA_PORTNUMBER");
    }

    private String getPortNumber() {
        return configProperties.getConfig("QA_PORTNUMBER");
    }

    public String getUserName() {
        return configProperties.getConfig("QA_USERNAME");
    }

    public String getPassword() {
       return configProperties.getConfig("QA_PASSWORD");
    }
}
