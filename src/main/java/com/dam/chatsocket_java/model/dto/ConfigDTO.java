package com.dam.chatsocket_java.model.dto;

import com.dam.chatsocket_java.model.domain.Settings;

public class ConfigDTO {

    private static ConfigDTO _newInstance;
    private Settings config;

    private ConfigDTO() {
        this.config = new Settings();
    }

    private ConfigDTO(Settings config) {
        this.config = config;
    }

    public static ConfigDTO getInstance(){
        if(_newInstance == null){
            _newInstance = new ConfigDTO();
        }
        return _newInstance;
    }

    public static Settings getSetting(){
        if(_newInstance == null){
            _newInstance = new ConfigDTO();
        }
        return _newInstance.config;
    }

    public static void setConfig(){
        _newInstance = new ConfigDTO();
    }

    public static void setConfig(Settings config){
        _newInstance = new ConfigDTO(config);
    }

}
