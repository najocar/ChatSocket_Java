package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.Rooms;

import java.io.Serializable;

public class RoomsDAO implements Serializable {

    private static ConnectionXML connection = new ConnectionXML();

    public boolean writeRoom(Room room){
        boolean result = false;
        Rooms aux = connection.loadXMLRooms();
        if(room != null && aux != null){
            aux.getRooms().add(String.valueOf(room.getIdRoom()));
            connection.writeXMLRooms(aux);
            result = true;
        }
        return result;
    }

    public boolean writeRoom(Rooms rooms){
        boolean result = false;
        if(rooms != null){
            connection.writeXMLRooms(rooms);
            result = true;
        }
        return result;
    }

    public Rooms readRooms(){
        return connection.loadXMLRooms();
    }

    public boolean removeRoom(Room room){
        boolean result = false;
        Rooms aux = connection.loadXMLRooms();
        if(room != null && aux != null){
            aux.getRooms().remove(String.valueOf(room.getIdRoom()));
            connection.writeXMLRooms(aux);
            result = true;
        }
        return result;
    }
}
