package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.utils.LoggerClass;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * RoomDAO Class is a point to get data to room_[].xml by connectionXML
 */
public class RoomDAO {
    ConnectionXML connection = new ConnectionXML();
    static LoggerClass logger = new LoggerClass(RoomDAO.class.getName());

    /**
     * Method to read room passed by param
     * @param room
     * @return Room
     */
    public Room readRoom(Room room){
        Room result = null;
        if(room != null){
            try {
                result = connection.loadXMLRoom(room);
            } catch (JAXBException | IllegalArgumentException e) {
                logger.warning("Error reading room"+ room.getIdRoom() +".xml file");
            } catch (Exception e){
                logger.warning("An unexpected error has occurred");
            }
        }
        return result;
    }

    /**
     * Method to write room in xml file passed by param
     * @param room
     * @return boolean
     * true if success
     */
    public boolean writeRoom(Room room){
        boolean result = false;
        if(room != null){
            try {
                connection.writeXMLRoom(room);
                result = true;
            } catch (IOException | JAXBException e) {
                logger.warning("Error reading room"+ room.getIdRoom() +".xml file");
            } catch (Exception e){
                logger.warning("An unexpected error has occurred");
            }
        }
        return result;
    }

    /**
     * Method to remove xml file passed by param
     * @param room
     * @return boolean
     * true if success
     */
    public boolean removeRoom(Room room){
        boolean result = false;
        if(room != null){
            try{
                File roomFile = new File("room_"+room.getIdRoom()+".xml");
                result = roomFile.delete();
            }catch (IllegalArgumentException e){
                logger.warning("File room_"+ room.getIdRoom() +".xml does not exist");
            }catch (Exception e) {
                logger.warning("An unexpected error has occurred");
            }
        }
        return result;
    }
}
