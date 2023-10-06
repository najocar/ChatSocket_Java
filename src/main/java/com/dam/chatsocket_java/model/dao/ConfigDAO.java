package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Settings;
import com.dam.chatsocket_java.utils.LoggerClass;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * ConfigDAO Class is a point to get data to config.xml by connectionXML class
 */
public class ConfigDAO {

    ConnectionXML connection = new ConnectionXML();
    static LoggerClass logger = new LoggerClass(ConfigDAO.class.getName());

    /**
     * Method to read config.xml and return Settings Class
     * @return Settings
     */
    public Settings loadConfig(){
        Settings result = new Settings();
        try {
            result = connection.loadXMLConfig();
        } catch (IOException | IllegalArgumentException | JAXBException e) {
            logger.warning("Error reading configuration file");
        } catch (Exception e){
            logger.warning("An unexpected error has occurred");
        }
        return result;
    }

}
