package com.restassured.core.common;

import com.restassured.core.rest.RestAssuredClient;
import com.restassured.utils.ConfigProperties;
import org.apache.log4j.Logger;

public abstract class CoreUtils {

    public static ConfigProperties configProperties = ConfigProperties.getInstance();
    static Logger log = Logger.getLogger(RestAssuredClient.class);

    public String getEnvironmentURL() {
        if (System.getProperty("env.type").equals("QA")) {
            return configProperties.getConfig("QA_BASE_URI") + ":" + getPortNumber();
        } else {
            return null;
        }
    }

    private String getPortNumber() {
        if (System.getProperty("env.type").equals("QA")) {
            return configProperties.getConfig("QA_PORTNUMBER");
        }
        return null;
    }

    public String getUserName() {
        if (System.getProperty("env.type").equals("QA")) {
            log.info("user name is:" + configProperties.getConfig("QA_USERNAME"));
            return configProperties.getConfig("QA_USERNAME");
        } else {
            return null;
        }
    }

    public String getPassword() {
        if (System.getProperty("env.type").equals("QA")) {
            log.info("Password is:" + configProperties.getConfig("QA_PASSWORD"));
            return configProperties.getConfig("QA_PASSWORD");
        } else {
            return null;
        }
    }
}
