package com.restassured.core.common;

import com.restassured.utils.ConfigProperties;

public abstract class CoreUtils {

    public static ConfigProperties configProperties = ConfigProperties.getInstance();

    public String getEnvironmentURL() {
        return configProperties.getConfig("QA_BASE_URI")+":"+configProperties.getConfig("QA_PORTNUMBER");
    }

    public int getPortNumber() {
        return Integer.parseInt(configProperties.getConfig("QA_PORTNUMBER"));
    }

    public String getUserName() {
        return configProperties.getConfig("QA_USERNAME");
    }

    public String getPassword() {
       return configProperties.getConfig("QA_PASSWORD");
    }


}
