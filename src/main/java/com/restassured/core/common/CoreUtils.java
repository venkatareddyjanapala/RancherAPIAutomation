package com.restassured.core.common;

import com.restassured.utils.ConfigProperties;

public abstract class CoreUtils {

    public static ConfigProperties configProperties = ConfigProperties.getInstance();
    public String getEnvironmentURL(){
        if (System.getProperty("env.type").equals("QA")) {
            return configProperties.getConfig("QA_BASE_URI")+":"+getPortNumber();
        }else {
            return null;
        }
    }
    private String getPortNumber(){
        if (System.getProperty("env.type").equals("QA")) {
            return configProperties.getConfig("QA_PORTNUMBER");
        }
        return null;
    }
    public String getUserName(){
        if (System.getProperty("env.type").equals("QA")) {
            System.out.println("user name is:" + configProperties.getConfig("QA_USERNAME"));
            return configProperties.getConfig("QA_USERNAME");
        }else {
            return null;
        }
    }
    public String getPassword(){
        if (System.getProperty("env.type").equals("QA")) {
            System.out.println("user name is:" + configProperties.getConfig("QA_PASSWORD"));

            return configProperties.getConfig("QA_PASSWORD");
        }else {
            return null;
        }
    }
}
