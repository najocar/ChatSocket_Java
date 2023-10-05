package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Settings;
import com.dam.chatsocket_java.model.dto.ConfigDTO;
import com.dam.chatsocket_java.utils.LoggerClass;

import javax.xml.bind.JAXBException;

public class ConfigDAO {

    ConnectionXML connection = new ConnectionXML();
    static LoggerClass logger = new LoggerClass(ConfigDAO.class.getName());


    public Settings loadConfig(){
        Settings result = new Settings();
        try {
            result = connection.loadXMLConfig();
        } catch (JAXBException e) {
            logger.warning("Error reading configuration file");
        }
        return result;
    }

}
