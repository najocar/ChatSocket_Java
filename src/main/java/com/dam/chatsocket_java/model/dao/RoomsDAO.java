package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.utils.LoggerClass;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;

public class RoomsDAO implements Serializable {

    private static ConnectionXML connection = new ConnectionXML();
    static LoggerClass logger = new LoggerClass(RoomsDAO.class.getName());

    public boolean writeRoom(Room room){
        boolean result = false;
        try{
            Rooms aux = connection.loadXMLRooms();
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

    public boolean writeRoom(Rooms rooms){
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

    public Rooms readRooms(){
        Rooms result = new Rooms();
        try {
            result = connection.loadXMLRooms();
        } catch (JAXBException | IllegalArgumentException e) {
            logger.warning("Error reading Rooms.xml file");
        } catch (Exception e){
            logger.warning("An unexpected error has occurred");
        }
        return result;
    }

    public boolean removeRoom(Room room){
        boolean result = false;
        try {
            Rooms aux = connection.loadXMLRooms();
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
