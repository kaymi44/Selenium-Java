package org.example.properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String WRONG_DATA_ALERT = readConfig().getString("wrongDataAlert");
    String SUCCESS_REMIND_PASSWORD_INFO = readConfig().getString("successRemindPasswordInfo");
    String ERROR_REMIND_PASSWORD_INFO = readConfig().getString("errorRemindPasswordInfo");

    String USER_LOGIN = readConfig().getString("user.login");
    String USER_PASSWORD = readConfig().getString("user.password");
    String USER_USERNAME = readConfig().getString("user.username");
}
