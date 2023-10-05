package com.dam.chatsocket_java.model.dto;

import com.dam.chatsocket_java.model.domain.Settings;

import java.io.File;

public class ConfigDTO {

    private static ConfigDTO _newInstance;
    private static Settings config;

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

    public static boolean checkConnectionFiles(){
        if(_newInstance == null)return false;
        File roomsFile = new File(config.getFileRooms());
        if(!roomsFile.exists() || !roomsFile.isFile() || !roomsFile.canRead() || !roomsFile.canWrite()){
            return false;
        }
        File usersFile = new File(config.getFileUsers());
        if(!usersFile.exists() || !usersFile.isFile() || !usersFile.canRead() || !usersFile.canWrite()){
            return false;
        }
        return true;
    }

}
