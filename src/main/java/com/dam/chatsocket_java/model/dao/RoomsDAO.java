package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.RoomsList;
import com.dam.chatsocket_java.utils.LoggerClass;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;

/**
 * RoomsDAO Class is a point to get data to rooms.xml by connectionXML class
 */
public class RoomsDAO implements Serializable {

    private static ConnectionXML connection = new ConnectionXML();
    static LoggerClass logger = new LoggerClass(RoomsDAO.class.getName());

    /**
     * Method to write room in rooms.xml file passed by param
     * @param room
     * @return boolean
     * true if success
     */
    public boolean writeRoom(Room room){
        boolean result = false;
        try{
            RoomsList aux = connection.loadXMLRooms();
            if(room != null && aux != null){
                aux.getRooms().add(String.valueOf(room.getIdRoom()));
                connection.writeXMLRooms(aux);
                result = true;
            }
        } catch (JAXBException | IllegalArgumentException e) {
            logger.warning("Error reading Rooms.xml file");
        }catch (Exception e){
            logger.warning("An unexpected error has occurred");
        }

        return result;
    }

    /**
     * Method to overwrite rooms.xml file passed by param
     * @param rooms
     * @return boolean
     * true if success
     */
    public boolean writeRoom(RoomsList rooms){
        boolean result = false;
        if(rooms != null){
            try {
                connection.writeXMLRooms(rooms);
                result = true;
            } catch (JAXBException | IOException e) {
                logger.warning("Error when trying to overwrite Rooms.xml file");
            } catch (Exception e){
                logger.warning("An unexpected error has occurred");
            }
        }
        return result;
    }

    /**
     * Method to read all rooms to rooms.xml file
     * @return Rooms
     */
    public RoomsList readRooms(){
        RoomsList result = new RoomsList();
        try {
            result = connection.loadXMLRooms();
        } catch (JAXBException | IllegalArgumentException e) {
            logger.warning("Error reading Rooms.xml file");
        } catch (Exception e){
            logger.warning("An unexpected error has occurred");
        }
        return result;
    }

    /**
     * Method to remove room to rooms.xml file passed by param
     * @param room
     * @return boolean
     * true if success
     */
    public boolean removeRoom(Room room){
        boolean result = false;
        try {
            RoomsList aux = connection.loadXMLRooms();
            if(room != null && aux != null){
                aux.getRooms().remove(String.valueOf(room.getIdRoom()));
                connection.writeXMLRooms(aux);
                result = true;
            }
        } catch (JAXBException | IllegalArgumentException e) {
            logger.warning("Error reading Rooms.xml file");
        } catch (Exception e){
            logger.warning("An unexpected error has occurred");
        }
        return result;
    }
}
