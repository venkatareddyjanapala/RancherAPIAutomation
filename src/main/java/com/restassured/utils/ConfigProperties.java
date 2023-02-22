package com.restassured.utils;

import java.util.Properties;

    public  class ConfigProperties {
        private static ConfigProperties SINGLE_INSTANCE = null;
        private ConfigProperties() {
        }
        public static ConfigProperties getInstance() {
            if (SINGLE_INSTANCE == null) {
                SINGLE_INSTANCE = new ConfigProperties();
                loadConfigs();
            }
            System.out.println("the single instance is:" + SINGLE_INSTANCE.toString());
            return SINGLE_INSTANCE;
        }

        private static Properties configProperties;

        public static void loadConfigs() {
            try {
                if (null == configProperties)
                    configProperties = new Properties();
                configProperties.load(ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getConfig(String key) {
            String env = System.getProperty("env.type");
            if (null == env) {
                    env = "QA";
            }
           String config = configProperties.getProperty(key);
            return config;
        }

    }
